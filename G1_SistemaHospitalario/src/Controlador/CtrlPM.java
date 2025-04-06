
package Controlador;

import Modelo.Consultas;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.*;
import javax.swing.*;

/**
 *
 * @author fernandafajardo
 */
public class CtrlPM implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final PantallaMedico vistaPM;
    private final Login vistaLogin;

    public CtrlPM(RegistroU modelo, Consultas consulta, PantallaMedico vistaPM, Login vistaLogin) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaPM = vistaPM;
        this.vistaLogin = vistaLogin;
        this.vistaPM.btnSalir.addActionListener(this);
        this.vistaPM.btnMostrarCitas.addActionListener(this);
    }
    
    public void iniciar(){
        vistaPM.setVisible(true);
        vistaPM.setLocationRelativeTo(null);
    }
    
    public PantallaMedico getVista(){
        return vistaPM;
    }
    
    public void mostrarCitasMedico() {
        String medicoLogueado = modelo.getUsuario(); // Obtenemos el usuario del médico logueado

        try (BufferedReader br = new BufferedReader(new FileReader("citas.txt"))) {
            String linea;
            StringBuilder citasInfo = new StringBuilder();
            boolean hayCitas = false;

            // Leemos cada línea del archivo de citas
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    String paciente = partes[0];
                    String medico = partes[1];
                    String fecha = partes[2];
                    String hora = partes[3];

                    // Validamos si la cita corresponde al médico logueado
                    if (medico.equals(medicoLogueado)) {
                        // Agregamos la información de la cita a un StringBuilder
                        citasInfo.append("Paciente: ").append(paciente)
                                 .append("\nFecha: ").append(fecha)
                                 .append("\nHora: ").append(hora)
                                 .append("\n\n");
                        hayCitas = true;
                    }
                }
            }

            // Si hay citas, las mostramos en el área de texto, si no, mostramos un mensaje indicando que no hay citas
            if (hayCitas) {
                vistaPM.txtInfoCitas.setText(citasInfo.toString());
            } else {
                vistaPM.txtInfoCitas.setText("No hay citas agendadas para el médico logueado.");
            }
        } catch (IOException e) {
            MensajeDialogo.mostrarMensaje("Error al leer el archivo de citas: " + e.getMessage(), "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //botón mostrarCita
        if(e.getSource() == vistaPM.btnMostrarCitas){
            mostrarCitasMedico();
        }
        
        //botón salir
        if(e.getSource() == vistaPM.btnSalir){
            vistaPM.dispose();
            vistaLogin.setVisible(true);
        }  
    }   
}
