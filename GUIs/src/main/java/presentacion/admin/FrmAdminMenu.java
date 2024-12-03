/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.admin;

import presentacion.admin.usuarios.FrmGestionarUsuarios;
import entidades.Usuario;
import presentacion.FrmLogin;
import presentacion.admin.alumnos.FrmGestionarAlumnos;
import presentacion.admin.maestro.FrmGestionarMaestro;
/**
 *
 * @author PC
 */
public class FrmAdminMenu extends javax.swing.JFrame {

    Usuario usuario;

    /**
     * Creates new form FrmAdminUsuarios
     */
    public FrmAdminMenu() {
        initComponents();
    }

    public FrmAdminMenu(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEventos = new javax.swing.JLabel();
        btnSesiones = new javax.swing.JLabel();
        btnClases = new javax.swing.JLabel();
        btnMaestros = new javax.swing.JLabel();
        btnAlumnos = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JLabel();
        lblAdminMenu = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JLabel();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnEventos.png"))); // NOI18N
        btnEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 200, 100));

        btnSesiones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnSesiones.png"))); // NOI18N
        btnSesiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnSesiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 200, 100));

        btnClases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnClases.png"))); // NOI18N
        btnClases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 200, 100));

        btnMaestros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnMaestros.png"))); // NOI18N
        btnMaestros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaestrosMouseClicked(evt);
            }
        });
        getContentPane().add(btnMaestros, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 200, 100));

        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnAlumnos.png"))); // NOI18N
        btnAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlumnosMouseClicked(evt);
            }
        });
        getContentPane().add(btnAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 200, 100));

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnUsuarios.png"))); // NOI18N
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 200, 100));

        lblAdminMenu.setBackground(new java.awt.Color(255, 255, 255));
        lblAdminMenu.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAdminMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminMenu.setText("Admin Menu");
        getContentPane().add(lblAdminMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 230, 50));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseClicked(evt);
            }
        });
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 50));

        imgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frm.png"))); // NOI18N
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseClicked
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        FrmGestionarUsuarios gestionarUsuarios = new FrmGestionarUsuarios();
        gestionarUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlumnosMouseClicked
        FrmGestionarAlumnos gestionarAlumnos = new FrmGestionarAlumnos();
        gestionarAlumnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAlumnosMouseClicked

    private void btnMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaestrosMouseClicked
        FrmGestionarMaestro gestionarMaestro = new FrmGestionarMaestro();
        gestionarMaestro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMaestrosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAlumnos;
    private javax.swing.JLabel btnCerrarSesion;
    private javax.swing.JLabel btnClases;
    private javax.swing.JLabel btnEventos;
    private javax.swing.JLabel btnMaestros;
    private javax.swing.JLabel btnSesiones;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel lblAdminMenu;
    // End of variables declaration//GEN-END:variables
}
