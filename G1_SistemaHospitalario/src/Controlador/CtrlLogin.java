
package Controlador;

import Modelo.Consultas;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaPaciente;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fernandafajardo
 */
public class CtrlLogin implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final Login vista;
    private CtrlRegistro ctrlRegistro;
    private CtrlPP ctrlPaciente;
    private CtrlPM ctrlMedico;

    public CtrlLogin(RegistroU modelo, Consultas consulta, Login vista) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnLogin.addActionListener(this);
    }
    
    public void setCtrlRegistro(CtrlRegistro ctrlRegistro) {
        this.ctrlRegistro = ctrlRegistro;
    }
    
    public void setCtrlPaciente(CtrlPP ctrlPaciente){
        this.ctrlPaciente = ctrlPaciente;
    }
    
    public void setCtrlMedico(CtrlPM ctrlMedico){
        this.ctrlMedico = ctrlMedico;
    }
    
    public void iniciar(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
    public void limpiar(){
        vista.txtUsuario.setText("");
        vista.txtPW.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //botón crear nuevo usuario
        if(e.getSource() == vista.btnCrear){
            vista.setVisible(false);
            ctrlRegistro.iniciar();
        }
        
        //botón login
        if(e.getSource() == vista.btnLogin){
            String usuario = vista.txtUsuario.getText().trim();
            char [] passwordArray = vista.txtPW.getPassword();
            String pw = new String(passwordArray).trim();
            
            StringBuilder errores = new StringBuilder();
            
            //Validar campos
            if(usuario.isEmpty()){
                errores.append("El campo de usuario no puede estar vacío.\n");
                vista.txtUsuario.setText("");
            }
            if(pw.isEmpty()){
                errores.append("El campo de contraseña no puede estar vacío.\n");
                vista.txtPW.setText("");
            }
        
            //Si hubo errores,se mostrará mensaje
            if(errores.length() > 0){
                MensajeDialogo.mostrarMensaje(errores.toString(), "Errores de Validación", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //Configuramos el modelo
            modelo.setUsuario(usuario);
            modelo.setContrasena(pw);
            
            if (consulta.login(modelo)) {
                limpiar();
                vista.dispose();

                if ("Paciente".equalsIgnoreCase(modelo.getRol())) {
                    ctrlPaciente.iniciar();
                } else if ("Médico".equalsIgnoreCase(modelo.getRol())) {
                    ctrlMedico.iniciar(); // Llamamos al nuevo controlador para médicos
                }
            }
            
            
//            //Inicia sesión
//            if(consulta.login(modelo)){
//                limpiar();
//                vista.dispose();
//                ctrlPaciente.iniciar();
//            }
        }
        
    }
    
        
}
