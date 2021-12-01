package Modelo;

public class CarroCompras {
   
    private String Nombre_Producto;
    private int Cantidad_Producto;
    private int Precio_Producto;
    private String Nombre_Usuario;
    
   public CarroCompras(String Nombre_Producto, int Cantidad_Producto, int Precio_Producto, String Nombre_Usuario) {
        this.Nombre_Producto = Nombre_Producto;
        this.Cantidad_Producto = Cantidad_Producto;
        this.Precio_Producto = Precio_Producto;
        this.Nombre_Usuario = Nombre_Usuario;
    }
   
    public CarroCompras(){
        
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public int getCantidad_Producto() {
        return Cantidad_Producto;
    }

    public void setCantidad_Produto(int Cantidad) {
        this.Cantidad_Producto = Cantidad_Producto;
    }

    public int getPrecio_Producto() {
        return Precio_Producto;
    }

    public void setPrecio_Producto(int Precio_Producto) {
        this.Precio_Producto = Precio_Producto;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }
    
    
}
