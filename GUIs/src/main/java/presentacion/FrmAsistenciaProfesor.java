/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

/**
 *
 * @author joel_
 */
public class FrmAsistenciaProfesor extends javax.swing.JFrame {

    /**
     * Creates new form FrmAsistenciaProfesor
     */
    public FrmAsistenciaProfesor() {
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

        jPanel2 = new javax.swing.JPanel();
        MenuBTN = new javax.swing.JLabel();
        NombreProfesorLabel = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        CarreraLabel = new javax.swing.JLabel();
        IMGLabel = new javax.swing.JLabel();
        ITSONlogo = new javax.swing.JLabel();
        CerrarBTN = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        MateriasLabel = new javax.swing.JLabel();
        Clase1Label = new javax.swing.JLabel();
        Clase2Label = new javax.swing.JLabel();
        Clase3Label = new javax.swing.JLabel();
        Clase4Label = new javax.swing.JLabel();
        MoreLabel = new javax.swing.JLabel();
        IMGClase1 = new javax.swing.JLabel();
        IMGClase2 = new javax.swing.JLabel();
        IMGClase3 = new javax.swing.JLabel();
        IMGClase4 = new javax.swing.JLabel();
        IMGClaseOtros = new javax.swing.JLabel();
        Clase1MenuBTN = new javax.swing.JLabel();
        Clase2MenuBTN = new javax.swing.JLabel();
        Clase3MenuBTN = new javax.swing.JLabel();
        Clase4MenuBTN = new javax.swing.JLabel();
        ClaseOtrosMenuBTN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(2, 24, 133));

        MenuBTN.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        MenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N

        NombreProfesorLabel.setText("Nombre Profesor");

        IDLabel.setText("00000000000");

        CarreraLabel.setText("Ing.Software");

        IMGLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        ITSONlogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/Logo ITSON.png"))); // NOI18N

        CerrarBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/Exit.png"))); // NOI18N
        CerrarBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ITSONlogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(IMGLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NombreProfesorLabel)
                        .addGap(261, 261, 261))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDLabel)
                            .addComponent(CarreraLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MenuBTN)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CerrarBTN)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CerrarBTN)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IMGLabel)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(MenuBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(NombreProfesorLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CarreraLabel)
                                    .addGap(7, 7, 7)
                                    .addComponent(IDLabel)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(ITSONlogo)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(27, 57, 166));

        MateriasLabel.setText("Materia");

        Clase1Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Clase1Label.setText("Clase1");

        Clase2Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Clase2Label.setText("Clase2");

        Clase3Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Clase3Label.setText("Clase3");

        Clase4Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Clase4Label.setText("Clase4");

        MoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MoreLabel.setText("...");

        IMGClase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        IMGClase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        IMGClase3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        IMGClase4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        IMGClaseOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/image.png"))); // NOI18N

        Clase1MenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N
        Clase1MenuBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clase1MenuBTNMouseClicked(evt);
            }
        });

        Clase2MenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N

        Clase3MenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N

        Clase4MenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N

        ClaseOtrosMenuBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AsistenciaProfesorResources/btnReturn.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(IMGClase3)
                        .addGap(18, 43, Short.MAX_VALUE)
                        .addComponent(Clase3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(IMGClase4)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(Clase4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MateriasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(IMGClase1)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(Clase1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(IMGClase2)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(Clase2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IMGClaseOtros)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(MoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 788, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Clase1MenuBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Clase2MenuBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Clase3MenuBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Clase4MenuBTN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ClaseOtrosMenuBTN, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(MateriasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clase1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMGClase1)
                    .addComponent(Clase1MenuBTN))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clase2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMGClase2)
                    .addComponent(Clase2MenuBTN))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clase3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMGClase3)
                    .addComponent(Clase3MenuBTN))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clase4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMGClase4)
                    .addComponent(Clase4MenuBTN))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IMGClaseOtros)
                        .addComponent(ClaseOtrosMenuBTN)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarBTNMouseClicked
        this.dispose();
    }//GEN-LAST:event_CerrarBTNMouseClicked

    private void Clase1MenuBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clase1MenuBTNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Clase1MenuBTNMouseClicked

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
            java.util.logging.Logger.getLogger(FrmAsistenciaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAsistenciaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAsistenciaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAsistenciaProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAsistenciaProfesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarreraLabel;
    private javax.swing.JLabel CerrarBTN;
    private javax.swing.JLabel Clase1Label;
    private javax.swing.JLabel Clase1MenuBTN;
    private javax.swing.JLabel Clase2Label;
    private javax.swing.JLabel Clase2MenuBTN;
    private javax.swing.JLabel Clase3Label;
    private javax.swing.JLabel Clase3MenuBTN;
    private javax.swing.JLabel Clase4Label;
    private javax.swing.JLabel Clase4MenuBTN;
    private javax.swing.JLabel ClaseOtrosMenuBTN;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel IMGClase1;
    private javax.swing.JLabel IMGClase2;
    private javax.swing.JLabel IMGClase3;
    private javax.swing.JLabel IMGClase4;
    private javax.swing.JLabel IMGClaseOtros;
    private javax.swing.JLabel IMGLabel;
    private javax.swing.JLabel ITSONlogo;
    private javax.swing.JLabel MateriasLabel;
    private javax.swing.JLabel MenuBTN;
    private javax.swing.JLabel MoreLabel;
    private javax.swing.JLabel NombreProfesorLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
