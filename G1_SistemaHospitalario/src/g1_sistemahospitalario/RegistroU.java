/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g1_sistemahospitalario;

/**
 *
 * @author fernandafajardo
 */
public class RegistroU {
   
    private String usuario,telefono, correo, contrasena, rol;

    public RegistroU() {
        this.usuario = "";
        this.telefono = "";
        this.correo = "";
        this.contrasena = "";
        this.rol = "";
    }

    public RegistroU(String usuario, String telefono, String correo, String contrasena, String rol) {
        this.usuario = usuario;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    public RegistroU(String usuario, String telefono, String correo) {
        this.usuario = usuario;
        this.telefono = telefono;
        this.correo = correo;
    }

    public RegistroU(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public void registroUsuario(){
        System.out.println("Usuario registrado: " + usuario);
    }
}
