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
public class CitaConfirmada extends EstadoCita {

    public CitaConfirmada(Cita cita) {
        super(cita);
    }
    
    @Override
    public void procesarCita(){
        System.out.println("Cita confirmada");
    }
    
    @Override
    public String generarInforme(){
        return "Cita confirmada con " + cita.getMedico().getUsuario();
    }
}
