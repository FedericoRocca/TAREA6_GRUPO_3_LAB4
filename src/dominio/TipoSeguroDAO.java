package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoSeguroDAO
{
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    /* 
     *      Para poder probar c/u cambien la contraseña por la de su entorno.
     *      También tienen que apuntar al driver correcto
     *      Tambien tienen que agregar el "Deployment Assembly"
    */
    private String pass = "root";
    private String dbName= "SegurosGroup";
    private String aditionalConfig = "?serverTimezone=UTC";
    
    public ArrayList<TipoSeguro>getTiposSeguros()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        ArrayList<TipoSeguro> listaSeguros = new ArrayList<TipoSeguro>();
        Connection cn = null;
        try {
            
            cn = DriverManager.getConnection(host+dbName+aditionalConfig, user,pass);
            Statement st = cn.createStatement();
            
            ResultSet rs=st.executeQuery("select idTipo, descripcion from segurosgroup.tiposeguros;");
            
            while(rs.next()) {
                
                TipoSeguro tipos = new TipoSeguro();
                tipos.setIdTipo(rs.getInt("idTipo"));
                tipos.setDescripcion(rs.getString("descripcion"));
                
                listaSeguros.add(tipos);
                
            }
            cn.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {}
        
        return listaSeguros;
    }
    
    public TipoSeguro ObtenerSeguro(int id) {
    	try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        TipoSeguro seg = new TipoSeguro();
        Connection cn = null;
        try {
            
            cn = DriverManager.getConnection(host+dbName+aditionalConfig, user,pass);
            Statement st = cn.createStatement();
            
            ResultSet rs=st.executeQuery("select idTipo, descripcion from segurosgroup.tiposeguros where idtipo = "+id+ ";");
            
            while(rs.next()) {
                seg.setIdTipo(rs.getInt("idTipo"));
                seg.setDescripcion(rs.getString("descripcion"));                    
            }
            cn.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return seg;
    }
}
