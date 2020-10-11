package dominio;

public class Seguro
{
    private int id;
    private String descripcion;
    private int idTipo;
    private float costo;
    private float costoMaximoAsegurado;
    
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    /**
     * @return the tipo
     */
    public int getTipo()
    {
        return idTipo;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo)
    {
        this.idTipo = tipo;
    }
    /**
     * @return the costo
     */
    public float getCosto()
    {
        return costo;
    }
    /**
     * @param costo the costo to set
     */
    public void setCosto(float costo)
    {
        this.costo = costo;
    }
    /**
     * @return the costoMaximoAsegurado
     */
    public float getCostoMaximoAsegurado()
    {
        return costoMaximoAsegurado;
    }
    /**
     * @param costoMaximoAsegurado the costoMaximoAsegurado to set
     */
    public void setCostoMaximoAsegurado(float costoMaximoAsegurado)
    {
        this.costoMaximoAsegurado = costoMaximoAsegurado;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Seguro [id=" + id + ", descripcion=" + descripcion + ", tipo=" + idTipo + ", costo=" + costo
                + ", costoMaximoAsegurado=" + costoMaximoAsegurado + "]";
    }
    
    public Seguro(int id, String descripcion, int tipo, float costo, float costoMaximoAsegurado)
    {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.idTipo = tipo;
        this.costo = costo;
        this.costoMaximoAsegurado = costoMaximoAsegurado;
    }
    
    public Seguro()
    {
        id = 0;
        descripcion = "";
        idTipo = 0;
        costo = 0;
        costoMaximoAsegurado = 0;
    }
    
}
