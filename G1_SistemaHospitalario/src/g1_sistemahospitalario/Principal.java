/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g1_sistemahospitalario;

import Controlador.CtrlLogin;
import Controlador.CtrlPP;
import Controlador.CtrlRegistro;
import Modelo.Consultas;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaPaciente;
import Vista.Registro;

/**
 *
 * @author fernandafajardo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RegistroU reg = new RegistroU();
        Consultas cons = new Consultas();
        Login vista = new Login();
        Registro vistaR = new Registro();
        PantallaPaciente vistaPP = new PantallaPaciente();
        
        CtrlLogin ctrlL = new CtrlLogin(reg, cons, vista);
        CtrlRegistro ctrlR = new CtrlRegistro(reg, cons,vistaR);
        CtrlPP ctrlpp = new CtrlPP(reg, cons, vistaPP);
        
        ctrlL.iniciar();
    }
 
}
