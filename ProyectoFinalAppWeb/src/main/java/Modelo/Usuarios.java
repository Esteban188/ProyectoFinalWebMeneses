
package Modelo;
import java.text.SimpleDateFormat;


public class Usuarios {
    
    private String ID_Usuario;
    private String Nombre_Usuario;
    private String Password_Usuario;
    private String Apellidos_Usuario;
    private String Email_Usuario;
    private String Telefono_Usuario;
    private String Direccion_Usuario;
    private String Rol_Usuario;
    
    public Usuarios (String ID_Usuario,String Nombre_Usuario,String Password_Usuario,String Apellidos_Usuario,String Email_Usuario,
                     String Telefono_Usuario,String Direccion_Usuario,String Rol_Usuario ){
        this.ID_Usuario= ID_Usuario;
        this.Nombre_Usuario= Nombre_Usuario;
        this.Password_Usuario= Password_Usuario;
        this.Apellidos_Usuario= Apellidos_Usuario;
        this.Email_Usuario = Email_Usuario;
        this.Telefono_Usuario= Telefono_Usuario;
        this.Direccion_Usuario= Direccion_Usuario;
        this.Rol_Usuario= Rol_Usuario;
        
    }    
    
    public Usuarios() {
        
    }

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public String getPassword_Usuario() {
        return Password_Usuario;
    }

    public void setPassword_Usuario(String Password_Usuario) {
        this.Password_Usuario = Password_Usuario;
    }

    public String getApellidos_Usuario() {
        return Apellidos_Usuario;
    }

    public void setApellidos_Usuario(String Apellidos_Usuario) {
        this.Apellidos_Usuario = Apellidos_Usuario;
    }

    public String getEmail_Usuario() {
        return Email_Usuario;
    }

    public void setEmail_Usuario(String Email_Usuario) {
        this.Email_Usuario = Email_Usuario;
    }

    public String getTelefono_Usuario() {
        return Telefono_Usuario;
    }

    public void setTelefono_Usuario(String Telefono_Usuario) {
        this.Telefono_Usuario = Telefono_Usuario;
    }

    public String getDireccion_Usuario() {
        return Direccion_Usuario;
    }

    public void setDireccion_Usuario(String Direccion_Usuario) {
        this.Direccion_Usuario = Direccion_Usuario;
    }

    public String getRol_Usuario() {
        return Rol_Usuario;
    }

    public void setRol_Usuario(String Rol_Usuario) {
        this.Rol_Usuario = Rol_Usuario;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "ID_Usuario=" + ID_Usuario + ", Nombre_Usuario=" + 
                Nombre_Usuario + ", Password_Usuario=" + Password_Usuario + ", Apellidos_Usuario=" + 
                Apellidos_Usuario + ", Email_Usuario=" + Email_Usuario + ", Telefono_Usuario=" + 
                Telefono_Usuario + ", Direccion_Usuario=" + Direccion_Usuario + ", Rol_Usuario=" + Rol_Usuario + '}';
    }
    
}
