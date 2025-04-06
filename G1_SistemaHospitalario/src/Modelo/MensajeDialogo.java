
package Modelo;

import javax.swing.*;

/**
 *
 * @author fernandafajardo
 */
public class MensajeDialogo {
    
    // Método estático para mostrar un mensaje con un icono personalizado
    public static void mostrarMensaje(String mensaje, String titulo, String rutaIcono, int tipoMensaje) {
        ImageIcon icono = null;
        
        // Verificar si se proporcionó una ruta válida
        if (rutaIcono != null && !rutaIcono.isEmpty()) {
            icono = new ImageIcon(rutaIcono);
        }
        // Mostrar el cuadro de diálogo con o sin icono
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje, icono);
    }
}
