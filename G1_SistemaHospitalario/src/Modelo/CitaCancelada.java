/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fernandafajardo
 */
public class CitaCancelada extends EstadoCita{
    
    public CitaCancelada(Cita cita) {
        super(cita);
    }

    @Override
    public void procesarCita() {
        System.out.println("Cita cancelada.");
    }

    @Override
    public String generarInforme() {
        return "Cita cancelada con:\n" + cita.getMedico().getUsuario();
    }
}
