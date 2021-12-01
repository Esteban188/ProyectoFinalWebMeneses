package Modelo;


public class WishList {
    
    private String Nombre_Producto;
    private int Cantidad;
    private int Precio_Producto;
    private String Nombre_Usuario;
    
    
    public WishList(String Nombre_Producto,int Cantidad,int Precio_Producto,String Nombre_Usuario ){
        this.Nombre_Producto= Nombre_Producto;
        this.Cantidad= Cantidad;
        this.Precio_Producto= Precio_Producto;
        this.Nombre_Usuario= Nombre_Usuario;
    }
    public WishList(){
        
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
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
