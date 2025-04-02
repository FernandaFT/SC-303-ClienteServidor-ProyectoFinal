
package Controlador;

import Modelo.Consultas;
import Modelo.MensajeDialogo;
import Modelo.RegistroU;
import Vista.Login;
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
    private final Login vistaLogin;

    public CtrlPP(RegistroU modelo, Consultas consulta, PantallaPaciente vistaPP, Login vistaLogin) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaPP = vistaPP;
        this.vistaLogin = vistaLogin;
        this.vistaPP.btnBuscar.addActionListener(this);
        this.vistaPP.btnModificarD.addActionListener(this);
        this.vistaPP.btnSalir.addActionListener(this);
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
        if(e.getSource() == vistaPP.btnModificarD){
            String usuario = vistaPP.txtNom.getText();
            String tel = vistaPP.txtTel.getText();
            String email = vistaPP.txtCorreo.getText();
            String pw = vistaPP.txtContr.getText();
            
            if(consulta.modificar(modelo)){
                MensajeDialogo.mostrarMensaje("Registro modificado", "Confirmación", "src/images/check.png", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
                MensajeDialogo.mostrarMensaje("Error al modificar", "Error", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }
        //botón salir
        if(e.getSource() == vistaPP.btnSalir){
            vistaPP.dispose();
            vistaLogin.setVisible(true);
        }
    }  
}
