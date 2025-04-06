
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
