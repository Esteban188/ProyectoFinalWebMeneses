
package Modelo;

public class Productos {
    
    private String ID_Prod;
    private String Nombre_Prod;
    private String Categoria_Prod;
    private String Tipo_Prod;
    private String Detalle_Prod;
    private String Imagen;
    private int Precio_Prod;
    private int Cantidad;
    
    public Productos (String ID_Prod,String Nombre_Prod,String Categoria_Prod,String Tipo_Prod,String Detalle_Prod,String Imagen,int Precio_Prod,int Cantidad){
        this.ID_Prod= ID_Prod;
        this.Nombre_Prod=Nombre_Prod;
        this.Categoria_Prod= Categoria_Prod;
        this.Tipo_Prod= Tipo_Prod;
        this.Detalle_Prod= Detalle_Prod;
        this.Imagen= Imagen;
        this.Precio_Prod= Precio_Prod;
        this.Cantidad= Cantidad;
        
    }
     public Productos() {
    }

    public String getID_Prod() {
        return ID_Prod;
    }

    public void setID_Prod(String ID_Prod) {
        this.ID_Prod = ID_Prod;
    }

    public String getNombre_Prod() {
        return Nombre_Prod;
    }

    public void setNombre_Prod(String Nombre_Prod) {
        this.Nombre_Prod = Nombre_Prod;
    }

    public String getCategoria_Prod() {
        return Categoria_Prod;
    }

    public void setCategoria_Prod(String Categoria_Prod) {
        this.Categoria_Prod = Categoria_Prod;
    }

    public String getTipo_Prod() {
        return Tipo_Prod;
    }

    public void setTipo_Prod(String Tipo_Prod) {
        this.Tipo_Prod = Tipo_Prod;
    }

    public String getDetalle_Prod() {
        return Detalle_Prod;
    }

    public void setDetalle_Prod(String Detalle_Prod) {
        this.Detalle_Prod = Detalle_Prod;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public int getPrecio_Prod() {
        return Precio_Prod;
    }

    public void setPrecio_Prod(int Precio_Prod) {
        this.Precio_Prod = Precio_Prod;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" + "ID_Prod=" + ID_Prod + ", Nombre_Prod=" + 
                Nombre_Prod + ", Categoria_Prod=" + Categoria_Prod + ", Tipo_Prod=" + 
                Tipo_Prod + ", Detalle_Prod=" + Detalle_Prod + ", Imagen=" + 
                Imagen + ", Precio_Prod=" + 
                Precio_Prod + ", Cantidad=" + 
                Cantidad + '}';
    }

   
}
