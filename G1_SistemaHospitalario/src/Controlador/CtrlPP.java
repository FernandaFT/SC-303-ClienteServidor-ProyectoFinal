
package Controlador;

import Modelo.Cita;
import Modelo.Consultas;
import Modelo.Medico;
import Modelo.MensajeDialogo;
import Modelo.Paciente;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author fernandafajardo
 */
public class CtrlPP implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final PantallaPaciente vistaPP;
    private final Login vistaLogin;

    public CtrlPP(RegistroU modelo, Consultas consulta, PantallaPaciente vistaPP, Login vistaLogin) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaPP = vistaPP;
        this.vistaLogin = vistaLogin;
        this.vistaPP.btnBuscar.addActionListener(this);
        this.vistaPP.btnModificarD.addActionListener(this);
        this.vistaPP.btnSalir.addActionListener(this);
        this.vistaPP.btnReservar.addActionListener(this);
        this.vistaPP.btnBuscarP.addActionListener(this);
        this.vistaPP.btnEliminar.addActionListener(this);
    }

    public void iniciar(){
        vistaPP.setVisible(true);
        vistaPP.setLocationRelativeTo(null);
        cargarMedicos();
        mostrarUsuarioLogueado();
    }
    
    public PantallaPaciente getVista(){
        return vistaPP;
    }
    
    public void limpiar(){
        vistaPP.txtNom.setText("");
        vistaPP.txtTel.setText("");
        vistaPP.txtCorreo.setText("");
        vistaPP.txtContr.setText("");
        vistaPP.txtNomC.setText("");
        vistaPP.txtFecha.setText("");
    }
    
    public void cargarMedicos(){
        List<String> medicos = consulta.obtenerMedicos();
        vistaPP.cmbSelectM.removeAllItems();
        for (String medico : medicos) {
        vistaPP.cmbSelectM.addItem(medico); // Agregar cada médico al JComboBox
        }
    }
    
    public void mostrarUsuarioLogueado() {
        String nombreUsuario = consulta.obtenerNombreUsuario(modelo.getUsuario());
        if (nombreUsuario != null) {
            vistaPP.txtNomC.setText(nombreUsuario);
        } else {
            vistaPP.txtNomC.setText("Usuario no encontrado");
        }
    }
    
    public void reservarCita(){
        String nombrePaciente = vistaPP.txtNomC.getText().trim();
        String medicoSeleccionado = (String) vistaPP.cmbSelectM.getSelectedItem();
        String fecha =  vistaPP.txtFecha.getText().trim();
        String hora = vistaPP.txtHora.getText().trim();
        
        if(nombrePaciente.isEmpty() || medicoSeleccionado == null || fecha.isEmpty() || hora.isEmpty()){
            MensajeDialogo.mostrarMensaje("Todos los campos son obligatorios", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCita = sdf.parse(fecha);
            
            //Crea instancia de cita
            Paciente paciente = new Paciente();
            paciente.setUsuario(nombrePaciente);
            
            Medico medico = new Medico();
            medico.setUsuario(medicoSeleccionado);
            
            Cita nuevaCita = new Cita(fechaCita, hora, paciente, medico);
            nuevaCita.confirmarCita();
            
            //Guarda cita en el archivo citas.txt
            guardarCitaArchivo(nuevaCita);
            
            //Mostrar el reporte en el área de texto
            vistaPP.txtInfoDatosC.setText(nuevaCita.generarReporteCita());
            
            MensajeDialogo.mostrarMensaje("Cita reservada con éxito", "Confirmación", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
            
            //Limpiar campos
            vistaPP.cmbSelectM.setSelectedIndex(0);
            vistaPP.txtFecha.setText("");
            vistaPP.txtHora.setText("");
        }catch(ParseException e){
            MensajeDialogo.mostrarMensaje("Formato de fecha incorrecto (dd/MM/yyyy)", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void guardarCitaArchivo(Cita cita) {
        try (FileWriter fw = new FileWriter("citas.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            pw.println(cita.getPaciente().getUsuario() + ";" + 
                       cita.getMedico().getUsuario() + ";" + 
                       new SimpleDateFormat("dd/MM/yyyy").format(cita.getFecha()) + ";" + 
                       cita.getHora());
        } catch (IOException e) {
            MensajeDialogo.mostrarMensaje("Error al guardar la cita", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void encontrarCita(){
        String fechaBuscar = vistaPP.txtFecha.getText().trim();
        
        try(BufferedReader br = new BufferedReader(new FileReader("citas.txt"))){
            String linea;
            boolean encontrada = false;
            while((linea = br.readLine()) != null){
                String [] partes = linea.split(";");
                if(partes.length == 4){
                    String paciente = partes[0];
                    String medico = partes[1];
                    String fecha = partes[2];
                    String hora = partes[3];
                    
                    if(fecha.equals(fechaBuscar)){
                        Paciente p = new Paciente();
                        p.setUsuario(paciente);
                        Medico m = new Medico();
                        m.setUsuario(medico);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaCita = sdf.parse(fecha);
                        
                        Cita cita = new Cita(fechaCita, hora, p,m);
                        vistaPP.txtInfoDatosC.setText(cita.generarReporteCita());
                        encontrada = true;
                        break; // solo se busca la primera coincidencia 
                    }
                }
            }
            if (!encontrada) {
                MensajeDialogo.mostrarMensaje("No se encontró ninguna cita para esa fecha", "Información", "src/images/mark.png", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(FileNotFoundException e){
            MensajeDialogo.mostrarMensaje("El archivo de citas no existe", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }catch(IOException | ParseException e){
            MensajeDialogo.mostrarMensaje("Error al buscar la cita: " + e.getMessage(), "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarCita(){
        String nombrePaciente = vistaPP.txtNomC.getText().trim();
        String medicoSeleccionado = (String) vistaPP.cmbSelectM.getSelectedItem();
        String fecha =  vistaPP.txtFecha.getText().trim();
        String hora = vistaPP.txtHora.getText().trim();
        
        if(nombrePaciente.isEmpty() || medicoSeleccionado == null || fecha.isEmpty() || hora.isEmpty()){
            MensajeDialogo.mostrarMensaje("Todos los campos son obligatorios", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCita = sdf.parse(fecha);
            
            File inputFile = new File("citas.txt");
            File tempFile = new File("canceladaCita.txt");
            
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
            
            String linea;
            boolean encontrada = false;
            while((linea = reader.readLine()) != null){
                String [] partes = linea.split(";");
                if(partes.length == 4){
                    String paciente = partes[0];
                    String medico = partes[1];
                    String fechaArchivo = partes[2];
                    String horaArchivo = partes[3];
                    
                    if(paciente.equals(nombrePaciente) && medico.equals(medicoSeleccionado) && fechaArchivo.equals(fecha) && horaArchivo.equals(hora)){
                        encontrada = true;
                        
                        //Creamos la cita para reportar la cancelación
                        Paciente p = new Paciente();
                        p.setUsuario(paciente);
                        Medico m = new Medico();
                        m.setUsuario(medico);
                        Cita citaCancelada = new Cita(fechaCita,horaArchivo, p, m);
                        citaCancelada.cancelarCita();
                        vistaPP.txtInfoDatosC.setText(citaCancelada.obtenerEstadoActual().generarInforme());
                    }else{
                        writer.println(linea);
                    }
                }
            }
            writer.close();
            reader.close();
            if(inputFile.delete() && tempFile.renameTo(inputFile)){
                if(encontrada){
                    MensajeDialogo.mostrarMensaje("Cita eliminada correctamente", "Confirmación", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    MensajeDialogo.mostrarMensaje("No se encontró la cita para eliminar", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                MensajeDialogo.mostrarMensaje("Error al procesar el archivo", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            MensajeDialogo.mostrarMensaje("Error al eliminar la cita: " + e.getMessage(), "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
        }
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        //botón buscar
        if(e.getSource() == vistaPP.btnBuscar){
            modelo.setUsuario(vistaPP.txtNom.getText().trim());

            if(consulta.buscar(modelo)){
                vistaPP.txtTel.setText(modelo.getTelefono());
                vistaPP.txtCorreo.setText(modelo.getCorreo());
                vistaPP.txtContr.setText(modelo.getContrasena());
                
                //Mostrar la info del Usuario en el box Datos
                String infoUsuario = String.format(
                    "Usuario: %s\nTeléfono: %s\nCorreo: %s\nContraseña: %s",
                    modelo.getUsuario(),
                    modelo.getTelefono(),
                    modelo.getCorreo(),
                    modelo.getContrasena()
                );
                vistaPP.txtInfoDatosP.setText(infoUsuario);
            }else{
                MensajeDialogo.mostrarMensaje("No se encontró registro", "Error", "src/images/mark.png", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }
        }
        
        //botón modificar
        if(e.getSource() == vistaPP.btnModificarD){
            modelo.setUsuario(vistaPP.txtNom.getText().trim());
            modelo.setTelefono(vistaPP.txtTel.getText().trim());
            modelo.setCorreo(vistaPP.txtCorreo.getText().trim());
            modelo.setContrasena(vistaPP.txtContr.getText().trim());

            if(consulta.modificar(modelo)){
                MensajeDialogo.mostrarMensaje("Registro modificado", "Confirmación", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
                //Mostrar la info del Usuario en el box Datos
                String infoUsuario = String.format(
                    "Usuario: %s\nTeléfono: %s\nCorreo: %s\nContraseña: %s",
                    modelo.getUsuario(),
                    modelo.getTelefono(),
                    modelo.getCorreo(),
                    modelo.getContrasena()
                );
                vistaPP.txtInfoDatosP.setText(infoUsuario);
                limpiar();
            } else {
                MensajeDialogo.mostrarMensaje("Error al modificar", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //botón reservar cita
        if(e.getSource() == vistaPP.btnReservar){
            reservarCita();
        }
        //botón buscar cita
        if(e.getSource() == vistaPP.btnBuscarP){
            encontrarCita();
        }
        //botón eliminar cita
        if(e.getSource() == vistaPP.btnEliminar){
            eliminarCita();
        }
        //botón salir
        if(e.getSource() == vistaPP.btnSalir){
            vistaPP.dispose();
            vistaLogin.setVisible(true);
        }
    }  
}
