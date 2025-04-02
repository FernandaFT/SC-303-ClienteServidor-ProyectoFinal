/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import g1_sistemahospitalario.*;
import java.util.List;

/**
 *
 * @author fernandafajardo
 */
public class Paciente extends RegistroU {
    
    private String numeroHistoriaClinica;
    private String fechaNacimiento;
    private List<String> enfermedadesPrevias;

    public Paciente() {
    }

    public Paciente(String numeroHistoriaClinica, String fechaNacimiento, List<String> enfermedadesPrevias, String usuario, String telefono, String correo) {
        super(usuario, telefono, correo);
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.fechaNacimiento = fechaNacimiento;
        this.enfermedadesPrevias = enfermedadesPrevias;
    }
    
    public void agregarEnfermedad(String enfermedad){
        enfermedadesPrevias.add(enfermedad);
    }

    public List<String> getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }
    
    public String consultarHistorialMedico(){
        return "Historial médico de " + getUsuario() + ": " + enfermedadesPrevias;
    }
}
