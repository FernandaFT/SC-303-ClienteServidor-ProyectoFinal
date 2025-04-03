/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author fernandafajardo
 */
public class Consultas extends Conexion {
      
    public boolean registro(RegistroU registro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        System.out.println("Conexión: " + con);
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
            //System.err.println("Error en SQL: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error en el registro: " + e.getMessage());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                //System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error en el registro: " + e.getMessage());
            }
        }
    }
  
    public boolean login(RegistroU usuario){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM registro WHERE usuario=? AND contrasena=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            rs = ps.executeQuery();
            
            if(rs.next()){
                String rol = rs.getString("rol");
                String nombreUsuario = rs.getString("usuario");
                usuario.setUsuario(nombreUsuario);
                usuario.setRol(rol);
                return true;
            }else{
                MensajeDialogo.mostrarMensaje("Usuario o Contraseña incorrectos", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
            
        }catch(SQLException e){
            System.err.println("Error en SQL: " + e.getMessage());
            return false;
        }finally{
            try{
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(con != null) con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
    public boolean buscar (RegistroU usuario){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM registro WHERE usuario=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                return true;
            }else{
                MensajeDialogo.mostrarMensaje("Usuario no encontrado", "Búsqueda", "src/images/mark.png", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }catch(SQLException e){
            System.err.println("Error en SQL: " + e.getMessage());
            return false;
        }finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(RegistroU usuario){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE registro SET telefono=?, correo=?, contrasena=? WHERE usuario=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getTelefono());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getUsuario());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0){
                MensajeDialogo.mostrarMensaje("Usuario modificado con éxito", "Modificación Exitosa", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                MensajeDialogo.mostrarMensaje("Usuario no encontrado", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                return false;
            }        
        }catch(SQLException e){
            System.err.println("Error en SQL: " + e.getMessage());
            return false;
        }finally{
            try{
                if(ps != null) ps.close();
                if(con != null) con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        } 
    }
    
    public String obtenerNombreUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT usuario FROM registro WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("usuario");
            }
        } catch (SQLException e) {
            System.err.println("Error en SQL: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return null; // Retorna null si no encuentra el usuario
    }

    
    public List<String> obtenerMedicos(){
        List<String> listaMedicos = new ArrayList<>();
        Connection con = getConexion();
        String sql = "SELECT usuario FROM registro WHERE rol = 'Medico'"; 
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                listaMedicos.add(rs.getString("usuario")); // Obtener el nombre del médico
            }
        } catch (SQLException e) {
            System.err.println("Error en SQL: " + e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return listaMedicos;
    }  
}
