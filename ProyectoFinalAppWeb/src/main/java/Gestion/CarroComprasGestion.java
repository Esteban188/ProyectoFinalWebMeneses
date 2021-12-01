
package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.CarroCompras;
import Modelo.Conexion;
/**
 *
 * @author JCubero
 */
public class CarroComprasGestion {
    private static final String SQL_SELECT_PRODUCTOS_DEL_CARRO_COMPRAS = "Select * from carro_compras where Nombre_Usuario=0";
    
    public static ArrayList<Modelo.CarroCompras> getcarrocompras (String nombre_usuario){
        
         ArrayList<Modelo.CarroCompras> lista = new ArrayList<>();
         
         try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS_DEL_CARRO_COMPRAS);
            consulta.setString(1, nombre_usuario);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new CarroCompras(rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CarroComprasGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //AÑADIR AL CARRITO
    private static final String SQL_AGREGAR_CARRO_COMPRAS = "insert into carro_compras (nombre_producto,cantidad_producto,precio_producto,nombre_usuario) values ("","","","")";
    private static final String SQL_ELIMINA_PRODUCTO = "update Productos set Cantidad=Cantidad-1 where Nombre_Producto=?";

    public static boolean AgregarCarroCompras(String nombre_producto, int cantidad_producto, int precio_producto, String nombre_usuario) {

        boolean resta;

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_AGREGAR_CARRO_COMPRAS);
            PreparedStatement sentencia2 = Conexion.getConexion().prepareCall(SQL_ELIMINA_PRODUCTO);
            sentencia.setString(1, nombre_producto);
            sentencia.setInt(2, cantidad_producto);
            sentencia.setInt(3, precio_producto);
            sentencia.setString(4, nombre_usuario);
            sentencia2.setString(1, nombre_producto);
            resta = sentencia2.executeUpdate() > 0;
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CarroComprasGestion.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
    
     private static final String SQL_SUMA_CANTIDAD = "select sum(Precio_Producto) from Carrito where Nombre_Usuario=?";

    public static int getsumaCantidad(String Nombre_Usuario) {

        try {
            int MontoPagar = 0;
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SUMA_CANTIDAD);
            consulta.setString(1, Nombre_Usuario);
            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                MontoPagar = rs.getInt(1);
            }
            return MontoPagar;

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    private static final String SQL_AGREGAR_VENTA = "insert into Ventas (Nombre_Producto,Cantidad,Precio_Producto,Nombre_Usuario) values (?,?,?,?)";
    private static final String SQL_ELIMINAR_CARRITO = "delete from Carrito where Nombre_Usuario=?";

    public static boolean realizarCompra(String Nombre_Usuario) {

        boolean limpiarCarrito = false;

        try {
            ArrayList<Carrito> Carrito = getCarritos(Nombre_Usuario);
            boolean validacionCompra;

            PreparedStatement consulta = Conexion.getConexion().prepareCall(SQL_AGREGAR_VENTA);
            PreparedStatement consulta2 = Conexion.getConexion().prepareCall(SQL_ELIMINAR_CARRITO);

            for (int i = 0; i < Carrito.size(); i++) {

                consulta.setString(1, Carrito.get(i).getNombre_Producto());
                consulta.setInt(2, Carrito.get(i).getCantidad());
                consulta.setInt(3, Carrito.get(i).getPrecio_Producto());
                consulta.setString(4, Carrito.get(i).getNombre_Usuario());
                validacionCompra = consulta.executeUpdate() > 0;

            }

            consulta2.setString(1, Nombre_Usuario);
            limpiarCarrito = consulta2.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return limpiarCarrito;

    }

    //VER VENTAS DEL USUARIO LOGEADO
    private static final String SQL_VER_PEDIDOS = "Select * from Ventas where Nombre_Usuario=?";

    public static ArrayList<Carrito> getVentas(String Nombre_Usuario) {

        ArrayList<Carrito> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_VER_PEDIDOS);
            consulta.setString(1, Nombre_Usuario);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Carrito(rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
