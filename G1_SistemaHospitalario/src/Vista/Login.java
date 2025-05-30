/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author fernandafajardo
 */
public class Login extends javax.swing.JFrame {
    
    //Consultas consultas = new Consultas();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
//    public void limpiar(){
//        txtUsuario.setText("");
//        txtPW.setText("");
//    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPW = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JToggleButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Kodchasan", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Médico");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Kodchasan", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 204));
        jLabel5.setText("Centro");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Kodchasan", 1, 16)); // NOI18N
        jLabel6.setText("Iniciar Sesión");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Kodchasan", 0, 16)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 240, 30));

        jLabel2.setFont(new java.awt.Font("Kodchasan", 0, 16)); // NOI18N
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        txtPW.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        txtPW.setBorder(null);
        jPanel1.add(txtPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 240, 30));

        btnLogin.setFont(new java.awt.Font("Kodchasan", 0, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 204, 204));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 240, -1));

        jLabel3.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        jLabel3.setText("¿No tienes una cuenta?");
        jLabel3.setAlignmentY(0.0F);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        btnCrear.setFont(new java.awt.Font("Kodchasan", 0, 13)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 204, 204));
        btnCrear.setText("Crear");
        btnCrear.setAlignmentY(0.0F);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 150, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg-image.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, -3, 370, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // Me redirige a la pantalla de Registro
//        Registro reg = new Registro();
//        this.dispose();
//        reg.setVisible(true);
//        reg.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
//        char[] passwordArray = txtPW.getPassword();
//  
//        String usuario = txtUsuario.getText();
//        String pw = new String(passwordArray);
//        
//        StringBuilder errores = new StringBuilder();
//        
//        //Validar campos
//        if(usuario.isEmpty()){
//            errores.append("El campo de usuario no puede estar vacío.\n");
//            txtUsuario.setText("");
//        }
//        if(pw.isEmpty()){
//            errores.append("El campo de contraseña no puede estar vacío.\n");
//            txtPW.setText("");
//        }
//        
//        //Si hubo errores,se mostrará mensaje
//        if(errores.length() > 0){
//            MensajeDialogo.mostrarMensaje(errores.toString(), "Errores de Validación", "src/images/mark.png", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        
//        RegistroU usuarioLogin = new RegistroU();
//        usuarioLogin.setUsuario(usuario);
//        usuarioLogin.setContrasena(pw);
//        
//        boolean exito = consultas.login(usuarioLogin);
//        if (exito) {
//            limpiar();
//            this.dispose();
//        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    public javax.swing.JToggleButton btnCrear;
    public javax.swing.JToggleButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField txtPW;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
