
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
    }
    
    public void iniciar(){
        vistaPM.setVisible(true);
        vistaPM.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
    
    
}
