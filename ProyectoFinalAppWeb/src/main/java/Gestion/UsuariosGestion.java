
package Gestion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Conexion;
import Modelo.Usuarios;
/**
 *
 * @author JCubero
 */
public class UsuariosGestion {
    
    
    private static final String SQL_VALIDA_USUARIO = "select identificacion,Nombre_Usuario,Nombre_Completo,Email,Numero_Telefono,Direccion,Rol from Usuarios where Nombre_Usuario=? and Password=MD5(?)";
    private static final String SQL_AGREGA_USUARIO = "insert into Usuarios (identificacion,Nombre_Usuario,Password,Nombre_Completo,Email,Numero_Telefono,Direccion) values(?,?,MD5(?),?,?,?,?)";

    public static Usuario ValidaUsuario(String Nombre_Usuario, String Password) {

        Usuario usuario = null;

        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_VALIDA_USUARIO);
            consulta.setString(1, Nombre_Usuario);
            consulta.setString(2, Password);
            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(rs.getString(1), Nombre_Usuario, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public static boolean insertarUsuario(Usuario usuario) {

        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_AGREGA_USUARIO);
            sentencia.setString(1, usuario.getIdentificacion());
            sentencia.setString(2, usuario.getNombre_Usuario());
            sentencia.setString(3, usuario.getPassword());
            sentencia.setString(4, usuario.getNombre_Completo());
            sentencia.setString(5, usuario.getEmail());
            sentencia.setString(6, usuario.getNumero_Telefono());
            sentencia.setString(7, usuario.getDireccion());

            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    private static final String SQL_VER_USUARIOS = "Select * from Usuarios";

    public static ArrayList<Usuario> getUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<>();

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_VER_USUARIOS);
            ResultSet rs = consulta.executeQuery();
            while (rs != null && rs.next()) {
                lista.add(new Usuario(rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CarritoGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //ACTUALIZAR USUARIO
    private static final String SQL_UPDATE_USUARIO = "update Usuarios set Nombre_Completo=?,Email=?,Numero_Telefono=?,Direccion=?,Rol=? where Nombre_Usuario=?";

    public static boolean actualiza(Usuario usuario) {

        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATE_USUARIO);
            sentencia.setString(1, usuario.getNombre_Completo());
            sentencia.setString(2, usuario.getEmail());
            sentencia.setString(3, usuario.getNumero_Telefono());
            sentencia.setString(4, usuario.getDireccion());
            sentencia.setString(5, usuario.getRol());
            sentencia.setString(6, usuario.getNombre_Usuario());
            return sentencia.executeUpdate() > 0; // Retorna true en caso de poder actualizar, false caso contrario

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static final String SQL_SELECT_USUARIO = "select * from Usuarios where identificacion=?";

    public static Usuario getUsuario(String identificacion) {

        Usuario usuario = null;

        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_USUARIO);
            consulta.setString(1, identificacion);
            ResultSet datos = consulta.executeQuery();

            if (datos.next()) {
                usuario = new Usuario(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8),
                        datos.getString(9));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;

    }

    
}
