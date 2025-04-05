
package Controlador;

import Modelo.Consultas;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author fernandafajardo
 */
public class CtrlPM implements ActionListener {
    
    private final RegistroU modelo;
    private final Consultas consulta;
    private final PantallaMedico vistaPM;
    private final Login vistaLogin;

    public CtrlPM(RegistroU modelo, Consultas consulta, PantallaMedico vistaPM, Login vistaLogin) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vistaPM = vistaPM;
        this.vistaLogin = vistaLogin;
        this.vistaPM.btnSalir.addActionListener(this);
    }
    
    public void iniciar(){
        vistaPM.setVisible(true);
        vistaPM.setLocationRelativeTo(null);
    }
    
    public PantallaMedico getVista(){
        return vistaPM;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //botón salir
        if(e.getSource() == vistaPM.btnSalir){
            vistaPM.dispose();
            vistaLogin.setVisible(true);
        }  
    }   
}
