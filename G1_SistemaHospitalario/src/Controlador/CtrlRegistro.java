
package Controlador;

import Modelo.Consultas;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.Login;
import Vista.Registro;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fernandafajardo
 */
public class CtrlRegistro implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final Registro vistaR;
    

    public CtrlRegistro(RegistroU modelo, Consultas consulta, Registro vistaR) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaR = vistaR;
        this.vistaR.btnCrearC.addActionListener(this);
    }
    
    public void iniciar(){
        vistaR.setVisible(true);
        vistaR.setLocationRelativeTo(null);
    }
    
    public void limpiar(){
        vistaR.txtUsuario.setText("");
        vistaR.txtTelefono.setText("");
        vistaR.txtEmail.setText("");
        vistaR.txtPW.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //botón crear usuario
        if(e.getSource() == vistaR.btnCrearC){
            
            String usuario = vistaR.txtUsuario.getText();
            String tel = vistaR.txtTelefono.getText();
            String email = vistaR.txtEmail.getText();
            String rol = vistaR.cmbMP.getSelectedItem().toString();
            char[] passwordArray = vistaR.txtPW.getPassword();
            String pw = new String(passwordArray);
        
            // Acumular los errores
            StringBuilder errores = new StringBuilder();

            // Validar los datos
            if (usuario.isEmpty()) {
                errores.append("El campo de usuario no puede estar vacío.\n");
                vistaR.txtUsuario.setText("");
            }
            if (tel.isEmpty() || !tel.matches("\\d{8}")) { //teléfono de 8 dígitos
                errores.append("El teléfono debe ser un número de 8 dígitos.\n");
                vistaR.txtTelefono.setText("");
            }
            if (email.isEmpty() || !email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) { // Validación básica de correo
                errores.append("El correo electrónico no es válido.\n");
                vistaR.txtEmail.setText("");
            }
            if (pw.isEmpty() || pw.length() < 6) { // Validar contraseña con longitud mínima
                errores.append("La contraseña debe tener al menos 6 caracteres.\n");
                vistaR.txtPW.setText("");
            }

            // Si hubo errores, mostrar los mensajes acumulados
            if (errores.length() > 0) {
                MensajeDialogo.mostrarMensaje(errores.toString(), "Errores de Validación", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Configuramos el modelo
            modelo.setUsuario(usuario);
            modelo.setTelefono(tel);
            modelo.setCorreo(email);
            modelo.setContrasena(pw);
            modelo.setRol(rol);
     
            //Se crea un nuevo usuario
            if (consulta.registro(modelo)) {
                limpiar();
                Login login = new Login();
                vistaR.dispose();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        }
    }
    
}
