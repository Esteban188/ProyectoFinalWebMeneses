
package Controller;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Gestion.CarroComprasGestion;
import Gestion.WishListGestion;
import Modelo.CarroCompras;
import Modelo.WishList;
/**
 *
 * @author JCubero
 */
public class WishListController {

   @Named(value = "listaDeseosController")
@SessionScoped
public class listaDeseosController extends Carrito implements Serializable {

    /**
     * Creates a new instance of listaDeseosController
     */
    public listaDeseosController() {
    }
    
     //Lista de deseos vinculada a la cuenta
    public List<listaDeseos> getListaDeseos(String Nombre_Usuario) {

        return ListaDeseosGestion.getListaDeseos(Nombre_Usuario);
    }
    
      public ArrayList<Carrito> getCarritos(String Nombre_Usuario) {

        return CarritoGestion.getCarritos(Nombre_Usuario);
    }
      
      

    public String AgregaListaDeseos(String Nombre_Producto, int Cantidad, int Precio, String Nombre_Usuario) {

        if (ListaDeseosGestion.AgregarListaDeseos(Nombre_Producto, Cantidad, Precio, Nombre_Usuario)) {

            return "#";

        } else {

            return "listaDeseos.xhtml";
        }

    }
    
      public String AgregarCarrito(String Nombre_Producto, int Cantidad, int Precio, String Nombre_Usuario) {

        if (CarritoGestion.AgregarCarrito(Nombre_Producto, Cantidad, Precio, Nombre_Usuario)) {

            return "#";

        } else {

            return "Carrito.xhtml";
        }

    }

    public String EliminarProductoListaDeseos(String Nombre_Producto, String Nombre_Usuario) {

        if (ListaDeseosGestion.eliminarListaDeseos(Nombre_Producto, Nombre_Usuario)) {
            return "listaDeseos.xhtml";
        } else {
            return "listaDeseos.xhtml";
        }

    }
    
}
