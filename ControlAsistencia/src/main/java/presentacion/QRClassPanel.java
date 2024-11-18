/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import entidades.Alumno;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import subsubsistemaqr.FachadaQR;
import subsubsistemaqr.IQR;

/**
 *
 * @author Ragzard
 */
public class QRClassPanel extends javax.swing.JPanel {

    MainWindow mainWindow;
    InicioPanel inicioPanel;
    IQR iqr = new FachadaQR();

    List<Alumno> listaAlumnosMock = new ArrayList<>();

    /**
     * Creates new form QRClassPanel
     *
     * @param mainwindow
     * @param inicioPanel
     */
    public QRClassPanel(MainWindow mainwindow, InicioPanel inicioPanel) {
        initComponents();

        this.mainWindow = mainwindow;
        this.inicioPanel = inicioPanel;

        Alumno alumno1 = new Alumno(4, 8.2f, 927384, "Pedro", "Ramirez", "Valenzuela", "pedro@gmail.com", "contrasenia");
        Alumno alumno2 = new Alumno(5, 8.75f, 123456, "Juan", "Pérez", "Gómez", "juan.perez@correo.com", "contrasenia123");
        Alumno alumno3 = new Alumno(3, 9.10f, 234567, "Ana", "Ramírez", "López", "ana.ramirez@correo.com", "seguridad321");
        Alumno alumno4 = new Alumno(7, 7.50f, 345678, "Carlos", "Martínez", "Vázquez", "carlos.martinez@correo.com", "abc123");
        Alumno alumno5 = new Alumno(2, 6.80f, 456789, "Marta", "Sánchez", "Pérez", "marta.sanchez@correo.com", "clave987");
        Alumno alumno6 = new Alumno(8, 9.50f, 567890, "Luis", "González", "Morales", "luis.gonzalez@correo.com", "pass456");
        Alumno alumno7 = new Alumno(4, 8.20f, 678901, "Elena", "Fernández", "Torres", "elena.fernandez@correo.com", "qwerty2024");
        Alumno alumno8 = new Alumno(6, 9.00f, 789012, "Pedro", "Díaz", "Serrano", "pedro.diaz@correo.com", "contraseña789");

        listaAlumnosMock.add(alumno1);
        listaAlumnosMock.add(alumno2);
        listaAlumnosMock.add(alumno3);
        listaAlumnosMock.add(alumno4);
        listaAlumnosMock.add(alumno5);
        listaAlumnosMock.add(alumno6);
        listaAlumnosMock.add(alumno7);
        listaAlumnosMock.add(alumno8);

        llenarTablaUsuariosMock(listaAlumnosMock);

        mostrarQR();
//        this.lblPIN.setText(iqr.generarQR().getContenido());

    }

    public void llenarTablaUsuariosMock(List<Alumno> listaMock) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaAlumnos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaMock != null) {
            listaMock.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getMatricula();
                fila[1] = row.getNombre();
                fila[2] = row.getApellidoPaterno();

                modeloTabla.addRow(fila);
            });
        }

    }

    private void mostrarQR() {
        iqr.generarQR();
        
        try {
            BufferedImage qrImage = ImageIO.read(new File(iqr.obtenerPathQR()));
            
            ImageIcon qrIcon = new ImageIcon(qrImage);
            
            imgQR.setIcon(qrIcon);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al manejar el archivo QR: " + e.getMessage());
        }
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
        headerPanel1 = new javax.swing.JPanel();
        lblImgClass1 = new javax.swing.JLabel();
        btnReturn1 = new javax.swing.JLabel();
        ItsonLogo1 = new javax.swing.JLabel();
        lblClassName1 = new javax.swing.JLabel();
        lblCodeClass1 = new javax.swing.JLabel();
        lblHourClass2 = new javax.swing.JLabel();
        imgQR = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblPIN = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContentPanel.setBackground(new java.awt.Color(27, 57, 166));
        ContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel1.setBackground(new java.awt.Color(2, 24, 133));
        headerPanel1.setPreferredSize(new java.awt.Dimension(1000, 120));
        headerPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImgClass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/image.png"))); // NOI18N
        headerPanel1.add(lblImgClass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 19, -1, -1));

        btnReturn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/btnReturn.png"))); // NOI18N
        btnReturn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn1.setPreferredSize(new java.awt.Dimension(20, 20));
        btnReturn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReturn1MouseClicked(evt);
            }
        });
        headerPanel1.add(btnReturn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 20, 30));

        ItsonLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ScanQRResources/Logo ITSON.png"))); // NOI18N
        headerPanel1.add(ItsonLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -10, -1, -1));

        lblClassName1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblClassName1.setForeground(new java.awt.Color(255, 255, 255));
        lblClassName1.setText("Nombre clase");
        headerPanel1.add(lblClassName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 19, -1, -1));

        lblCodeClass1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCodeClass1.setForeground(new java.awt.Color(255, 255, 255));
        lblCodeClass1.setText("01293924");
        headerPanel1.add(lblCodeClass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 70, 140, -1));

        lblHourClass2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHourClass2.setForeground(new java.awt.Color(255, 255, 255));
        lblHourClass2.setText("12:00 - 13:00");
        headerPanel1.add(lblHourClass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        ContentPanel.add(headerPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        ContentPanel.add(imgQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 295, 295));

        jSeparator1.setBackground(new java.awt.Color(26, 42, 97));
        jSeparator1.setForeground(new java.awt.Color(26, 42, 97));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 42, 97)));
        ContentPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 120, 2, 600));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumnos");
        ContentPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        ContentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 340, 490));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PIN:");
        ContentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, -1));

        lblPIN.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPIN.setForeground(new java.awt.Color(255, 255, 255));
        lblPIN.setText("0000");
        ContentPanel.add(lblPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alumnos:");
        ContentPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("00");
        ContentPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Presentes:");
        ContentPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 550, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("00");
        ContentPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, -1, -1));

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturn1MouseClicked
        mainWindow.changeContentPane(inicioPanel);
    }//GEN-LAST:event_btnReturn1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel ContentPanel;
    private javax.swing.JLabel ItsonLogo1;
    private javax.swing.JLabel btnReturn1;
    private javax.swing.JPanel headerPanel1;
    private javax.swing.JLabel imgQR;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblClassName1;
    private javax.swing.JLabel lblCodeClass1;
    private javax.swing.JLabel lblHourClass2;
    private javax.swing.JLabel lblImgClass1;
    private javax.swing.JLabel lblPIN;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
