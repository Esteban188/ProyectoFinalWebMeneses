
package Gestion;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import Modelo.Conexion;
import Modelo.Productos;
/**
 *
 * @author JCubero
 */
public class ProductosGestion {
    
    rivate static final String SQL_AGREGA_PRODUCTO = "insert into Productos(Categoria_Producto,Tipo_Producto,Nombre_Producto,Precio_Producto,Cantidad,Detalle_Producto,Codigo_Producto,Link_Imagen) values(?,?,?,?,?,?,?,?)";

    public static boolean agregaProducto(Producto producto) {

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_AGREGA_PRODUCTO);
            sentencia.setString(1, producto.getCategoria_Producto());
            sentencia.setString(2, producto.getTipo_Producto());
            sentencia.setString(3, producto.getNombre_Producto());
            sentencia.setInt(4, producto.getPrecio_Producto());
            sentencia.setInt(5, producto.getCantidad());
            sentencia.setString(6, producto.getDetalle_Producto());
            sentencia.setString(7, producto.getCodigo_Producto());
            sentencia.setString(8, producto.getLink_Imagen());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_SELECT_PRODUCTOS = "Select * from Productos";

    public static ArrayList<Producto> getProductos() {

        ArrayList<Producto> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Producto(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private static final String SQL_SELECT_PRODUCTOSXTIPO = "Select * from Productos where Tipo_Producto=?";

    public static ArrayList<Producto> getProductosbyTipo(String Tipo_Producto) {

        ArrayList<Producto> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOSXTIPO);
            consulta.setString(1, Tipo_Producto);
            ResultSet rs = consulta.executeQuery();

            while (rs != null && rs.next()) {
                lista.add(new Producto(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;

    }
    private static final String SQL_SELECT_PRODUCTO = "select * from Productos where Codigo_Producto=?";

    public static final Producto getProducto(String codigo) {

        Producto producto = null;

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTO);
            sentencia.setString(1, codigo);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return producto;
    }

    public static String GenerarJson() {

        Producto producto = new Producto();
        String tiraJson = "", Cantidad, Categoria_Producto, Codigo_Producto,
                Detalle_Producto, Link_Imagen, Nombre_Producto, Precio_Producto;

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRODUCTOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                producto.setCategoria_Producto(rs.getString("Categoria_Producto"));
                producto.setTipo_Producto(rs.getString("Tipo_Producto"));
                producto.setNombre_Producto(rs.getString("Nombre_Producto"));
                producto.setPrecio_Producto(rs.getInt("Precio_Producto"));
                producto.setCantidad(rs.getInt("Cantidad"));
                producto.setDetalle_Producto(rs.getString("Detalle_Producto"));
                producto.setCodigo_Producto(rs.getString("Codigo_Producto"));
                producto.setLink_Imagen(rs.getString("Link_Imagen"));

                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                JsonObject jsonObject = jsonObjectBuilder.
                        add("Cantidad del producto", producto.getCantidad()).
                        add("Nombre del producto", producto.getCategoria_Producto()).
                        add("Detalle del producto", producto.getCodigo_Producto()).
                        add("Categoria", producto.getDetalle_Producto()).
                        add("Unidades disponibles", producto.getLink_Imagen()).
                        add("Precio del producto", producto.getNombre_Producto()).
                        add("Tipo de producto", producto.getPrecio_Producto()).
                        add("Link de la imagen", producto.getTipo_Producto()).build();

                StringWriter tira = new StringWriter();
                JsonWriter jsonWriter = Json.createWriter(tira);
                jsonWriter.writeObject(jsonObject);

                if (tiraJson == null) {
                    tiraJson = tira.toString() + "\n";
                } else {
                    tiraJson = tiraJson + tira.toString() + "\n";
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tiraJson;
    }
    
}
