/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import g1_sistemahospitalario.*;

/**
 *
 * @author fernandafajardo
 */
public class Medico extends RegistroU {
    
    private Especialidad especialidad;
    private int numeroLicencia;
    private double salario;

    public Medico(Especialidad especialidad, int numeroLicencia, double salario, String usuario, String telefono, String correo) {
        super(usuario, telefono, correo);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
        this.salario = salario;
    }

    public Medico(String usuario, String telefono, String correo) {
        super(usuario, telefono, correo);
    }
    

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String verAgenda(){
        return "Mostrando agenda del médico: " + getUsuario();
    }
    
    public void gestionarCita(Cita cita){
        System.out.println("Gestionando cita con " + cita.getPaciente().getUsuario());
    }
}
