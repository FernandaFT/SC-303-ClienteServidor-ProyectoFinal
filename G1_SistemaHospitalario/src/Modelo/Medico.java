
package Modelo;

/**
 *
 * @author fernandafajardo
 */
public class Medico extends RegistroU {
    
    private Especialidad especialidad;
    private int numeroLicencia;

    public Medico(Especialidad especialidad, int numeroLicencia, String usuario, String telefono, String correo) {
        super(usuario, telefono, correo);
        this.especialidad = especialidad;
        this.numeroLicencia = numeroLicencia;
    }

    public Medico() {
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
}
