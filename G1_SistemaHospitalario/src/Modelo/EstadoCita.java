
package Modelo;

/**
 *
 * @author fernandafajardo
 */
public abstract class EstadoCita {
    
    protected Cita cita;

    public EstadoCita(Cita cita) {
        this.cita = cita;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
 
    public abstract void procesarCita();
    
    public abstract String generarInforme();
}
