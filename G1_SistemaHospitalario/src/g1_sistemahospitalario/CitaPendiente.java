/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g1_sistemahospitalario;

/**
 *
 * @author fernandafajardo
 */
public class CitaPendiente extends EstadoCita {

    public CitaPendiente(Cita cita) {
        super(cita);
    }
    
    @Override
    public void procesarCita(){
        System.out.println("Cita en estado pendiente");
    }
    
    @Override
    public String generarInforme(){
        return "Cita pendiente con " + cita.getMedico().getUsuario();
    }
}
