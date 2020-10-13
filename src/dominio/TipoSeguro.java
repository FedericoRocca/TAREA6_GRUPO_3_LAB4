package dominio;

public class TipoSeguro
{
    private int idTipo;
    private String descripcion;
    
    public TipoSeguro()
    {
        super();
    }
    
    public TipoSeguro(int idTipo, String descripcion)
    {
        super();
        this.idTipo = idTipo;
        this.descripcion = descripcion;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "TtipoSeguro [idTipo=" + idTipo + ", descripcion=" + descripcion + "]";
    }
    /**
     * @return the idTipo
     */
    public int getIdTipo()
    {
        return idTipo;
    }
    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo)
    {
        this.idTipo = idTipo;
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
}
