/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import presentacion.admin.FrmAdminMenu;
import javax.swing.JOptionPane;
import subsistemaUsuario.FachadaUsuario;
import subsistemaUsuario.IUsuario;

/**
 *
 * @author PC
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogoItson = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        lblFormLogin = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoItson.png"))); // NOI18N
        getContentPane().add(lblLogoItson, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 270, 30));
        getContentPane().add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 270, 30));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAceptar.png"))); // NOI18N
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClose.png"))); // NOI18N
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        lblFormLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginForm.png"))); // NOI18N
        getContentPane().add(lblFormLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        //JOptionPane.showMessageDialog(this, "Presionaste el boton aceptar!", "Success!", JOptionPane.INFORMATION_MESSAGE);

        IUsuario usuario = new FachadaUsuario();

        boolean valicacionIniciarSesion = usuario.iniciarSesion(Integer.parseInt(txtId.getText()), txtContrasenia.getText());

        String rolUsuario = usuario.getRolUsuario(Integer.parseInt(txtId.getText()));

        if (valicacionIniciarSesion == true) {
            if (rolUsuario.equalsIgnoreCase("admin")) {
                FrmAdminMenu adminMenu = new FrmAdminMenu();
                adminMenu.setVisible(true);
                this.dispose();
            } else {
                MainWindow mainWindow = new MainWindow(usuario.getUsuario(Integer.parseInt(txtId.getText())));
                mainWindow.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        int reply = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro que deseas cerrar la aplicación?",
                "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCloseMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblFormLogin;
    private javax.swing.JLabel lblLogoItson;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
