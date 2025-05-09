/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g1_sistemahospitalario;

import Controlador.CtrlLogin;
import Controlador.CtrlPM;
import Controlador.CtrlPP;
import Controlador.CtrlRegistro;
import Modelo.Consultas;
import Modelo.RegistroU;
import Vista.Login;
import Vista.PantallaMedico;
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
        
        //Crear los modelos
        RegistroU reg = new RegistroU();
        Consultas cons = new Consultas();
        
        //Crear las vistas
        Login vistaLogin = new Login();
        Registro vistaRegistro = new Registro();
        PantallaPaciente vistaPaciente = new PantallaPaciente();
        PantallaMedico vistaMedico = new PantallaMedico();
        
        //Crear los controladores
        CtrlLogin ctrlLogin = new CtrlLogin(reg,cons,vistaLogin);
        CtrlRegistro ctrlRegistro = new CtrlRegistro(reg, cons,vistaRegistro, vistaLogin);
        CtrlPP ctrlPaciente = new CtrlPP(reg, cons, vistaPaciente,vistaLogin);
        CtrlPM ctrlMedico = new CtrlPM(reg, cons, vistaMedico, vistaLogin);
        
        // Asignar la referencia de ctrlRegistro,ctrlPaciente,ctrlMedico a ctrlLogin
        ctrlLogin.setCtrlRegistro(ctrlRegistro);
        ctrlLogin.setCtrlPaciente(ctrlPaciente);
        ctrlLogin.setCtrlMedico(ctrlMedico);
        //Inicar la pantalla de Login
        ctrlLogin.iniciar();
    }
 
}
