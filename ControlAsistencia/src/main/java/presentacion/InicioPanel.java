/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import entidades.Usuario;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author Ragzard
 */
public class InicioPanel extends javax.swing.JPanel {

    MainWindow mainWindow;
    Usuario usuario;

    /**
     * Creates new form InicioPanel
     */
    public InicioPanel(MainWindow mainwindow) {
        initComponents();

        this.mainWindow = mainwindow;
        this.mainMenuContentPanel.setVisible(false);
                
                
    }

    public InicioPanel(MainWindow mainWindow, Usuario usuario){
        initComponents();
        this.mainWindow = mainWindow;
        this.mainMenuContentPanel.setVisible(false);
        
        this.usuario = usuario;
        
        this.lblId.setText(String.valueOf(usuario.getMatricula())); 
        this.lblNombre.setText(usuario.getNombre()); 
           
    }
    
    /**
     * Cambia el contenido del 'mainContentPanel' al panel dado por el
     * parametro.
     *
     * @param actualPanel un objeto de tipo JPanel.
     */
    private void changeContentPane(JPanel actualPanel) {
        this.mainMenuContentPanel.removeAll();
        this.mainMenuContentPanel.add(actualPanel);
        this.mainMenuContentPanel.revalidate();
        this.mainMenuContentPanel.repaint();
    }

    protected void closeMenu() {
        this.mainMenuContentPanel.setVisible(false);
    }

    public Set<String> hashSet = new HashSet<String>();

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainMenuContentPanel = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnMenu = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainMenuContentPanel.setOpaque(false);
        mainMenuContentPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainMenuContentPanelMouseExited(evt);
            }
        });
        mainMenuContentPanel.setLayout(new java.awt.CardLayout());
        add(mainMenuContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 0, 268, 283));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 102, 102));
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 280, 20));

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(51, 51, 51));
        add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 90, 20));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Menu desplegable.png"))); // NOI18N
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });
        add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InicioBG.jpg"))); // NOI18N
        fondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fondoMouseEntered(evt);
            }
        });
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        // TODO add your handling code here:
//        new FrmInicioMenu().setVisible(true);
        InicioMenu menu = new InicioMenu(mainWindow, this);
        changeContentPane(menu);
        this.mainMenuContentPanel.setVisible(true);

    }//GEN-LAST:event_btnMenuMouseClicked

    private void fondoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondoMouseEntered
        // TODO add your handling code here:
        this.mainMenuContentPanel.setVisible(false);
    }//GEN-LAST:event_fondoMouseEntered

    private void mainMenuContentPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMenuContentPanelMouseExited
        // TODO add your handling code here:
        /*NO BORRAR ESTE EVENTO :)
          Evita que el menu principal se cierre antes de tiempo.
         */

    }//GEN-LAST:event_mainMenuContentPanelMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMenu;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel mainMenuContentPanel;
    // End of variables declaration//GEN-END:variables
}
