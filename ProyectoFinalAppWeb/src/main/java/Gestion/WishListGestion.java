package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.CarroCompras;
import Modelo.Conexion;
import Modelo.WishList;
/**
 *
 * @author JCubero
 */
public class WishListGestion {
    
    public class ListaDeseosGestion extends Carrito{

    //Ver la lista de deseos 
    private static final String SQL_SELECT_PRODUCTOS_LISTADESEOS = "Select * from listaDeseos where Nombre_Usuario=?";

    public static ArrayList<listaDeseos> getListaDeseos(String Nombre_Usuario) {

        ArrayList<listaDeseos> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS_LISTADESEOS);
            consulta.setString(1, Nombre_Usuario);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new listaDeseos(rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ListaDeseosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Agregar productos a la lista de deseos
    private static final String SQL_AGREGAR_LISTADESEOS = "insert into listaDeseos (Nombre_Producto,Cantidad,Precio_Producto,Nombre_Usuario) values (?,?,?,?)";

    public static boolean AgregarListaDeseos(String Nombre_Producto, int Cantidad, int Precio, String Nombre_Usuario) {

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_AGREGAR_LISTADESEOS);

            sentencia.setString(1, Nombre_Producto);
            sentencia.setInt(2, Cantidad);
            sentencia.setInt(3, Precio);
            sentencia.setString(4, Nombre_Usuario);
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ListaDeseosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    //Eliminar productos de nuestra lista de deseos
    private static final String SQL_ELIMINAR_PRODUCTOLISTADESEOS = "delete from listaDeseos where Nombre_Producto=? && Nombre_Usuario=?";
    private static final String SQL_SUMAR_PRODUCTOLD = "update Productos set Cantidad=Cantidad+1 where Nombre_Producto=?";

    public static boolean eliminarListaDeseos(String Nombre_Producto, String Nombre_Usuario) {
        boolean suma;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_ELIMINAR_PRODUCTOLISTADESEOS);
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(SQL_SUMAR_PRODUCTOLD);
            sentencia.setString(1, Nombre_Producto);
            sentencia.setString(2, Nombre_Usuario);
            sentencia2.setString(1, Nombre_Producto);
            suma = sentencia2.executeUpdate() > 0;
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ListaDeseosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
    
   
  private static final String SQL_SELECT_PRODUCTOS_DEL_CARRITO = "Select * from Carrito where Nombre_Usuario=?";

    public static ArrayList<listaDeseos> getCarritos(String Nombre_Usuario) {

        ArrayList<listaDeseos> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS_DEL_CARRITO);
            consulta.setString(1, Nombre_Usuario);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new listaDeseos(rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }


    //AÑADIR AL CARRITO
    private static final String SQL_AGREGAR_CARRITO = "insert into Carrito (Nombre_Producto,Cantidad,Precio_Producto,Nombre_Usuario) values (?,?,?,?)";
    private static final String SQL_RESTA_PRODUCTO = "update Productos set Cantidad=Cantidad-1 where Nombre_Producto=?";

    public static boolean AgregarCarrito(String Nombre_Producto, int Cantidad, int Precio, String Nombre_Usuario) {

        boolean resta;

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_AGREGAR_CARRITO);
            PreparedStatement sentencia2 = Conexion.getConexion().prepareCall(SQL_RESTA_PRODUCTO);
            sentencia.setString(1, Nombre_Producto);
            sentencia.setInt(2, Cantidad);
            sentencia.setInt(3, Precio);
            sentencia.setString(4, Nombre_Usuario);
            sentencia2.setString(1, Nombre_Producto);
            resta = sentencia2.executeUpdate() > 0;
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ListaDeseosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    private static final String SQL_ELIMINAR_PRODUCTOCARRITO = "delete from Carrito where Nombre_Producto=? && Nombre_Usuario=?";
    private static final String SQL_SUMAR_PRODUCTO = "update Productos set Cantidad=Cantidad+1 where Nombre_Producto=?";

    public static boolean eliminarCarrito(String Nombre_Producto, String Nombre_Usuario) {

        boolean suma;

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_ELIMINAR_PRODUCTOCARRITO);
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(SQL_SUMAR_PRODUCTO);
            sentencia.setString(1, Nombre_Producto);
            sentencia.setString(2, Nombre_Usuario);
            sentencia2.setString(1, Nombre_Producto);
            suma = sentencia2.executeUpdate() > 0;
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ListaDeseosGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
}
