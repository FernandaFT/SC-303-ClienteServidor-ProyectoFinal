/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.*;
import java.util.*;

/**
 *
 * @author fernandafajardo
 */
public class Cita {
    
    private Date fecha;
    private String hora;
    private EstadoCita estado;
    private Paciente paciente;
    private Medico medico;

    public Cita(Date fecha, String hora, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void confirmarCita(){
        estado = new CitaConfirmada(this);
        System.out.println("Cita confirmada");
    }
    
    public void cancelarCita(){
        estado = new CitaCancelada(this);
        System.out.println("Cita cancelada.");
    }
    
    public void cambiarEstado(EstadoCita nuevoEstado){
        this.estado = nuevoEstado;
    }
    
    public EstadoCita obtenerEstadoActual(){
        return estado;
    }
    
    public String generarReporteCita(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fecha);
        
        return "Cita médica\n" + 
                "Fecha: " + fechaFormateada + "\n" +
                "Hora: " + hora + "\n" +
                "Médico: Dr(a)." + medico.getUsuario() + "\n";
                
    }
}
