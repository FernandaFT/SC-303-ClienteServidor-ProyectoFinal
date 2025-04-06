
package Controlador;

import Modelo.Consultas;
import Modelo.Especialidad;
import Modelo.Medico;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaMedico;
import Vista.PantallaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
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
        this.vistaPM.btnAnadirInfo.addActionListener(this);
        this.vistaPM.btnBack.addActionListener(this);
    }
    
    public void iniciar(){
        vistaPM.setVisible(true);
        vistaPM.setLocationRelativeTo(null);
        mostrarNombreMedico();
        cargarPacientesConCitas();
    }
    
    public PantallaMedico getVista(){
        return vistaPM;
    }
    
    public void mostrarNombreMedico(){
        String nombreM = modelo.getUsuario();
        if(nombreM != null){
            vistaPM.txtNombreDoc.setText(nombreM);
        }
    }
    
    public void limpiar(){
        vistaPM.txtNumLic.setText("");
        vistaPM.txtDiagnostico.setText("");
        vistaPM.txtMedicamentos.setText("");
    }
    
    public void cargarPacientesConCitas() {
        String medicoLogueado = modelo.getUsuario(); // Obtener el nombre de usuario del médico logueado
        Set<String> pacientesSet = new HashSet<>(); // Usamos Set para evitar duplicados

        try (BufferedReader br = new BufferedReader(new FileReader("citas.txt"))) {
            String linea;

            // Leer cada línea del archivo de citas
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    String paciente = partes[0];
                    String medico = partes[1];

                    // Verificar si la cita corresponde al médico logueado
                    if (medico.equals(medicoLogueado)) {
                        pacientesSet.add(paciente);
                    }
                }
            }

            // Limpiar el combo box y agregar los pacientes encontrados
            vistaPM.cmbTodosPacientes.removeAllItems();
            for (String paciente : pacientesSet) {
                vistaPM.cmbTodosPacientes.addItem(paciente);
            }

        } catch (FileNotFoundException e) {
            MensajeDialogo.mostrarMensaje("El archivo de citas no se encontró: " + e.getMessage(),"Archivo no encontrado","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            MensajeDialogo.mostrarMensaje("Error al leer el archivo de citas: " + e.getMessage(),"Error de lectura","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            MensajeDialogo.mostrarMensaje("Ocurrió un error inesperado: " + e.getMessage(),"Error","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
        }
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
        //botón añadir consulta del paciente
        if (e.getSource() == vistaPM.btnAnadirInfo) {
            try {
                // Obtener datos desde la vista
                String nombreMedico = vistaPM.txtNombreDoc.getText();
                String nombreEspecialidad = (String) vistaPM.cmbEspecialidad.getSelectedItem();
                String numLicenciaStr = vistaPM.txtNumLic.getText();
                String nombrePaciente = (String) vistaPM.cmbTodosPacientes.getSelectedItem();
                String diagnostico = vistaPM.txtDiagnostico.getText();
                String medicamentos = vistaPM.txtMedicamentos.getText();

                // Validaciones básicas
                if (nombreMedico.isEmpty() || nombreEspecialidad == null || numLicenciaStr.isEmpty()
                        || nombrePaciente == null || diagnostico.isEmpty() || medicamentos.isEmpty()) {
                    MensajeDialogo.mostrarMensaje("Por favor, complete todos los campos antes de guardar.","Campos incompletos","src/images/mark.png",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int numeroLicencia = Integer.parseInt(numLicenciaStr); // Parseo seguro con try/catch
                Especialidad especialidad = new Especialidad(nombreEspecialidad);

                // Validar especialidad con método propio
                if (!especialidad.validarEspecialidad()) {
                    MensajeDialogo.mostrarMensaje("Especialidad inválida.","Validación","src/images/mark.png",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Crear objeto médico (otros campos pueden ir vacíos si no se usan)
                Medico medico = new Medico(especialidad, numeroLicencia, nombreMedico, "", "");

                // Crear línea con los datos del diagnóstico
                String linea = medico.getUsuario() + ";" +
                               medico.getEspecialidad().getNombreEspecialidad() + ";" +
                               medico.getNumeroLicencia() + ";" +
                               nombrePaciente + ";" +
                               diagnostico + ";" +
                               medicamentos;

                // Escribir en el archivo de diagnóstico
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("diagnosticoPacientes.txt", true))) {
                    bw.write(linea);
                    bw.newLine();

                    // Mostrar en los campos correspondientes dentro de PantallaPaciente
                    PantallaPaciente.txtInfoDiagnostico.setText(diagnostico);
                    PantallaPaciente.txtInfoMedicamentos.setText(medicamentos);
                    limpiar();
                    MensajeDialogo.mostrarMensaje("Información guardada correctamente.","Éxito","src/images/check.png",JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                MensajeDialogo.mostrarMensaje("El número de licencia debe ser un valor numérico.","Error de formato","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                MensajeDialogo.mostrarMensaje("Error al guardar la información: " + ex.getMessage(),"Error","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                MensajeDialogo.mostrarMensaje("Ocurrió un error inesperado: " + ex.getMessage(),"Error","src/images/mark.png",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //botón back to inicio PPM
        if(e.getSource() ==  vistaPM.btnBack){
            vistaPM.TodasLasCitas.setVisible(true);
            vistaPM.panelCitas.setVisible(false);
            
        }
        
        //botón salir
        if(e.getSource() == vistaPM.btnSalir){
            vistaPM.dispose();
            vistaLogin.setVisible(true);
        }  
    }   
}
