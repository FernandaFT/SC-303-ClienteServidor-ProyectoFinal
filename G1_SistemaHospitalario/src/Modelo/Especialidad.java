
package Modelo;

/**
 *
 * @author fernandafajardo
 */
public class Especialidad {
    
    private String nombreEspecialidad;

    public Especialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    public boolean validarEspecialidad(){
        return nombreEspecialidad != null && !nombreEspecialidad.isEmpty();
    }
}
