
package Modelo;

import java.util.List;

/**
 *
 * @author fernandafajardo
 */
public class Paciente extends RegistroU {
    
    private String fechaNacimiento;
    private List<String> diagnosticoEnfermedades;

    public Paciente() {
    }

    public Paciente(String fechaNacimiento, List<String> diagnosticoEnfermedades, String usuario, String telefono, String correo) {
        super(usuario, telefono, correo);
        this.fechaNacimiento = fechaNacimiento;
        this.diagnosticoEnfermedades = diagnosticoEnfermedades;
    }

    public List<String> diagnosticoEnfermedades() {
        return diagnosticoEnfermedades;
    }
    
    public String consultarHistorialMedico(){
        return "Historial médico de " + getUsuario() + ": " + diagnosticoEnfermedades;
    }
}
