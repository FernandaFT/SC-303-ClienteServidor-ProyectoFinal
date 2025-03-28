/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g1_sistemahospitalario;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author fernandafajardo
 */
public class Consultas extends Conexion {
    
    
    public boolean registro(RegistroU registro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO registro(usuario, telefono, correo, contrasena, rol) VALUES(?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, registro.getUsuario());
            ps.setString(2, registro.getTelefono());
            ps.setString(3, registro.getCorreo());
            ps.setString(4, registro.getContrasena());
            ps.setString(5, registro.getRol());
            
            ps.execute();
            MensajeDialogo.mostrarMensaje("Usuario registrado con éxito", "Registro Exitoso", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
}
