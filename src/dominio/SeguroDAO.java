package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SeguroDAO
{
    private String host = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName= "SegurosGroup";
    private String aditionalConfig = "?serverTimezone=UTC";
    
    public int newSeguro(Seguro _seguro)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int filas=0;
        Connection cn = null;
        try
        {
            cn = DriverManager.getConnection(host+dbName+aditionalConfig, user,pass);
            Statement st = cn.createStatement();
            String query = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES "
                    + "('" + _seguro.getDescripcion() + "'," + _seguro.getTipo() +"," + _seguro.getCosto() + ", " + _seguro.getCostoMaximoAsegurado() + ");";
            filas=st.executeUpdate(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return filas;
    }
}