package dominio;

public class Seguro
{
    private int id;
    private String descripcion;
    private int idTipo;
    private float costo;
    private float costoMaximoAsegurado;
    private TipoSeguro tipo;
    

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescripcion()
    {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
 
    public int getTipo()
    {
        return idTipo;
    }

    public void setTipo(int tipo)
    {
        this.idTipo = tipo;
    }

    public float getCosto()
    {
        return costo;
    }

    public void setCosto(float costo)
    {
        this.costo = costo;
    }

    public float getCostoMaximoAsegurado()
    {
        return costoMaximoAsegurado;
    }
    
 
    public void setCostoMaximoAsegurado(float costoMaximoAsegurado)
    {
        this.costoMaximoAsegurado = costoMaximoAsegurado;
    }
    
    public String getDescripcionTipoSeguro() {
    	return tipo.getDescripcion();
    }
    
    public void SetearTipoSeguro() {
    	if(tipo == null) {
    		tipo = new TipoSeguro();   		
    	}
    	TipoSeguroDAO tsd = new TipoSeguroDAO();
    	tipo = tsd.ObtenerSeguro(getTipo());
    	tsd = null;
    }

    @Override
    public String toString()
    {
        return "Seguro [id=" + id + ", descripcion=" + descripcion + ", tipo=" + idTipo + ", costo=" + costo
                + ", costoMaximoAsegurado=" + costoMaximoAsegurado + "]";
    }
    
    public Seguro(String descripcion, int tipo, float costo, float costoMaximoAsegurado)
    {
        super();
        SeguroDAO data = new SeguroDAO();
        this.id = data.getLastID() + 1;
        System.out.println("lastID: ");
        this.descripcion = descripcion;
        this.idTipo = tipo;
        this.costo = costo;
        this.costoMaximoAsegurado = costoMaximoAsegurado;
    }
    
    public Seguro()
    {
        SeguroDAO data = new SeguroDAO();
        id = data.getLastID() + 1;
        descripcion = "";
        idTipo = 0;
        costo = 0;
        costoMaximoAsegurado = 0;
    }
    
}
