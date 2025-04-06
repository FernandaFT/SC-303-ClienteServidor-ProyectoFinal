
package Modelo;

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
        return "Cita confirmada con:\n" + cita.getMedico().getUsuario();
    }
}
