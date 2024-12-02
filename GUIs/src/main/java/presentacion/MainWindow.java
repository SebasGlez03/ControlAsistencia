/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.UsuarioDTO;
import entidades.Usuario;
import javax.swing.JPanel;

/**
 *
 * @author Ragzard
 */
public class MainWindow extends javax.swing.JFrame {

    int xx, xy;
    Usuario usuario;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();

        this.setLocationRelativeTo(null); //Centra la ventana de la app

        InicioPanel inicio = new InicioPanel(this); //Vista principal
        changeContentPane(inicio);

        System.out.println("Entro al constructor");
    }

    public MainWindow(Usuario usuario) {

        initComponents();

        this.setLocationRelativeTo(null); //Centra la ventana de la app
        this.usuario = usuario;
        InicioPanel inicio = new InicioPanel(this, getUsuario()); //Vista principal
        changeContentPane(inicio);

        System.out.println("Entro al constructor");

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Cambia el contenido del 'mainContentPanel' al panel dado por el
     * parametro.
     *
     * @param actualPanel un objeto de tipo JPanel.
     */
    protected void changeContentPane(JPanel actualPanel) {
        this.mainContentPanel.removeAll();
        this.mainContentPanel.add(actualPanel);
        this.mainContentPanel.revalidate();
        this.mainContentPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decoratorBar = new java.awt.Panel();
        btnExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainContentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        decoratorBar.setBackground(new java.awt.Color(0, 0, 86));
        decoratorBar.setPreferredSize(new java.awt.Dimension(1000, 35));
        decoratorBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                decoratorBarMousePressed(evt);
            }
        });
        decoratorBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                decoratorBarMouseDragged(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Exit.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Minimize.png"))); // NOI18N
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Control asistencia");

        javax.swing.GroupLayout decoratorBarLayout = new javax.swing.GroupLayout(decoratorBar);
        decoratorBar.setLayout(decoratorBarLayout);
        decoratorBarLayout.setHorizontalGroup(
            decoratorBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoratorBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 790, Short.MAX_VALUE)
                .addComponent(btnMinimize)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addContainerGap())
        );
        decoratorBarLayout.setVerticalGroup(
            decoratorBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoratorBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(decoratorBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, decoratorBarLayout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addContainerGap())
                    .addGroup(decoratorBarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(decoratorBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainContentPanel.setPreferredSize(new java.awt.Dimension(1000, 720));
        mainContentPanel.setRequestFocusEnabled(false);
        mainContentPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 1000, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void decoratorBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decoratorBarMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_decoratorBarMousePressed

    private void decoratorBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decoratorBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_decoratorBarMouseDragged

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private java.awt.Panel decoratorBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainContentPanel;
    // End of variables declaration//GEN-END:variables
}
