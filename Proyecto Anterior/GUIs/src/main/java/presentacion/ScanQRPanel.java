/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

/**
 *
 * @author Ragzard
 */
public class ScanQRPanel extends javax.swing.JPanel {

    MainWindow mainWindow;
    InicioPanel inicioPanel;
    
    /**
     * Creates new form ScanQRPanel
     */
    public ScanQRPanel(MainWindow mainwindow, InicioPanel inicioPanel) {
        initComponents();
        
        this.mainWindow = mainwindow;
        this.inicioPanel = inicioPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContentPanel = new java.awt.Panel();
        headerPanel = new javax.swing.JPanel();
        lblImgClass = new javax.swing.JLabel();
        btnReturn = new javax.swing.JLabel();
        ItsonLogo = new javax.swing.JLabel();
        lblClassName = new javax.swing.JLabel();
        lblCodeClass = new javax.swing.JLabel();
        lblHourClass1 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JTextField();
        lblScanCam = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        camDecorator = new javax.swing.JLabel();
        camBackground = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContentPanel.setBackground(new java.awt.Color(27, 57, 166));
        ContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(2, 24, 133));
        headerPanel.setPreferredSize(new java.awt.Dimension(1000, 120));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImgClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/image.png"))); // NOI18N
        headerPanel.add(lblImgClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 19, -1, -1));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/btnReturn.png"))); // NOI18N
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.setPreferredSize(new java.awt.Dimension(20, 20));
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturnMouseClicked(evt);
            }
        });
        headerPanel.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 20, 30));

        ItsonLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Logo ITSON.png"))); // NOI18N
        headerPanel.add(ItsonLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -10, -1, -1));

        lblClassName.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblClassName.setForeground(new java.awt.Color(255, 255, 255));
        lblClassName.setText("Nombre alumno");
        headerPanel.add(lblClassName, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 19, -1, -1));

        lblCodeClass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCodeClass.setForeground(new java.awt.Color(255, 255, 255));
        lblCodeClass.setText("01293924");
        headerPanel.add(lblCodeClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 70, 140, -1));

        lblHourClass1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHourClass1.setForeground(new java.awt.Color(255, 255, 255));
        lblHourClass1.setText("Ing. Software");
        headerPanel.add(lblHourClass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        ContentPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtPIN.setBackground(new java.awt.Color(53, 53, 53));
        txtPIN.setForeground(new java.awt.Color(255, 255, 255));
        txtPIN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPIN.setAutoscrolls(false);
        txtPIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        txtPIN.setPreferredSize(new java.awt.Dimension(101, 30));
        ContentPanel.add(txtPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 110, -1));

        lblScanCam.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblScanCam.setForeground(new java.awt.Color(255, 255, 255));
        lblScanCam.setText("Escanea el Código QR");
        ContentPanel.add(lblScanCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PIN");
        ContentPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, -1));

        camDecorator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Cam decorator.png"))); // NOI18N
        ContentPanel.add(camDecorator, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        camBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Background.png"))); // NOI18N
        ContentPanel.add(camBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Cancel btn.png"))); // NOI18N
        ContentPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, -1, -1));

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseClicked
        mainWindow.changeContentPane(inicioPanel);
    }//GEN-LAST:event_btnReturnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel ContentPanel;
    private javax.swing.JLabel ItsonLogo;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnReturn;
    private javax.swing.JLabel camBackground;
    private javax.swing.JLabel camDecorator;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblClassName;
    private javax.swing.JLabel lblCodeClass;
    private javax.swing.JLabel lblHourClass1;
    private javax.swing.JLabel lblImgClass;
    private javax.swing.JLabel lblScanCam;
    private javax.swing.JTextField txtPIN;
    // End of variables declaration//GEN-END:variables
}