
package Controller;
import Gestion.UsuariosGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import Modelo.Usuarios;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 *
 * @author JCubero
 */
public class UsuariosController {
    Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }

    static String usuarioLogeado = "Iniciar Sesion";
    static String usuarioRol = "";

    public String validaUsuario() {

        Usuario usuario = UsuarioGestion.ValidaUsuario(this.getNombre_Usuario(), this.getPassword());

        if (usuario != null) {

            usuarioLogeado = usuario.getNombre_Usuario();
            usuarioRol = usuario.getRol();

            return "index.xhtml";

        } else {

            return "login.xhtml";
        }

    }

    public String registraUsuario() {

        if (UsuarioGestion.insertarUsuario(this)) {

            return "ConfirmacionCreacionUsuario.xhtml";

        } else {

            return "registro.xhtml";
        }

    }

    public List<Usuario> getUsuarios() {

        return UsuarioGestion.getUsuarios();

    }

    public String prueba(String prueba) {
        return "Hola";

    }

    public String editaUsuario(String identificacion) {

        Usuario usuario = UsuarioGestion.getUsuario(identificacion);
        if (usuario != null) {
            this.setIdentificacion(usuario.getIdentificacion());
            this.setNombre_Completo(usuario.getNombre_Completo());
            this.setEmail(usuario.getEmail());
            this.setNumero_Telefono(usuario.getNumero_Telefono());
            this.setDireccion(usuario.getDireccion());
            this.setRol(usuario.getRol());
            this.setNombre_Usuario(usuario.getNombre_Usuario());
            return "editaUsuario.xhtml";

        } else {

            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Identificacion no registrada");
            FacesContext.getCurrentInstance().addMessage("listForm2", mensaje);
            return "editaUsuario.xhtml";
        }

    }

    public String actualizaUsuario() {

        if (UsuarioGestion.actualiza(this)) {
            return "listaClientes.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Identificacion no registrada");
            FacesContext.getCurrentInstance().addMessage("editaUsuarioForm", mensaje);
            return "editaUsuario.xhtml";

        }

    }

    public String usuarioLogeado() {

        if (usuarioLogeado != null) {

            return usuarioLogeado;

        } else {

            return "Iniciar sesion";
        }

    }

    public String getUsuarioLogeado(String usuario) {
        return usuarioLogeado;
    }

    public String usuarioRol() {

        if (usuarioRol != null) {

            return usuarioRol;

        } else {

            return "";
        }

    }

    public String getUsuarioRol(String rol) {
        return usuarioRol;
    }
}
