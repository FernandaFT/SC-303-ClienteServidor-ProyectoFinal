
package Controlador;

import Modelo.Consultas;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.PantallaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author fernandafajardo
 */
public class CtrlPP implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final PantallaPaciente vistaPP;

    public CtrlPP(RegistroU modelo, Consultas consulta, PantallaPaciente vistaPP) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaPP = vistaPP;
        this.vistaPP.btnBuscar.addActionListener(this);
        this.vistaPP.btnModificarD.addActionListener(this);
        this.vistaPP.btnReservar.addActionListener(this);
        this.vistaPP.btnEliminar.addActionListener(this);
    }

    public void iniciar(){
        vistaPP.setVisible(true);
        vistaPP.setLocationRelativeTo(null);

    }
    public void limpiar(){
        vistaPP.txtNom.setText("");
        vistaPP.txtTel.setText("");
        vistaPP.txtCorreo.setText("");
        vistaPP.txtContr.setText("");
        vistaPP.txtNomC.setText("");
        vistaPP.txtFecha.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //botón buscar
        if(e.getSource() == vistaPP.btnBuscar){
            modelo.setUsuario(vistaPP.txtNom.getText().trim());
            System.out.println("Buscando usuario: " + modelo.getUsuario());

            if(consulta.buscar(modelo)){
                vistaPP.txtTel.setText(modelo.getTelefono());
                vistaPP.txtCorreo.setText(modelo.getCorreo());
                vistaPP.txtContr.setText(modelo.getContrasena());
            }else{
                MensajeDialogo.mostrarMensaje("No se encontró registro", "Error", "src/images/mark.png", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }
        }
        //botón modificar
        //botón reservar
        //botón eliminar
  
    }
    
    
}
