/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import entidades.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author Ragzard
 */
public class FrmMaestroClases extends javax.swing.JPanel {

    MainWindow mainWindow;
    InicioPanel inicioPanel;
    Usuario usuario;

    /**
     * Creates new form QRClassPanel
     *
     * @param mainwindow
     * @param inicioPanel
     */
    public FrmMaestroClases(MainWindow mainwindow, InicioPanel inicioPanel, Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        this.mainWindow = mainwindow;
        this.inicioPanel = inicioPanel;


    }

    public void llenarTablaClases(List<Clase> listaClases) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaAlumnos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaClases != null) {
            listaClases.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.();
                fila[1] = row.getNombre();

                modeloTabla.addRow(fila);
            });
        }

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

        ContentPanel = new java.awt.Panel();
        headerPanel1 = new javax.swing.JPanel();
        lblImgClass1 = new javax.swing.JLabel();
        btnReturn1 = new javax.swing.JLabel();
        ItsonLogo1 = new javax.swing.JLabel();
        lblMaestroNombre = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblClases = new javax.swing.JLabel();
        tblClases = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();

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

        lblMaestroNombre.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblMaestroNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblMaestroNombre.setText("Nombre Maestro");
        headerPanel1.add(lblMaestroNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 19, 230, -1));

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        lblMatricula.setText("01293924");
        headerPanel1.add(lblMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, -1));

        ContentPanel.add(headerPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblClases.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblClases.setForeground(new java.awt.Color(255, 255, 255));
        lblClases.setText("Clases");
        ContentPanel.add(lblClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clase", "idClase", "QR Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClases.setViewportView(tablaAlumnos);
        if (tablaAlumnos.getColumnModel().getColumnCount() > 0) {
            tablaAlumnos.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaAlumnos.getColumnModel().getColumn(1).setMinWidth(0);
            tablaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(0);
            tablaAlumnos.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        ContentPanel.add(tblClases, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 690, 460));

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturn1MouseClicked
        mainWindow.changeContentPane(inicioPanel);
        inicioPanel.setUsuario(usuario);
    }//GEN-LAST:event_btnReturn1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel ContentPanel;
    private javax.swing.JLabel ItsonLogo1;
    private javax.swing.JLabel btnReturn1;
    private javax.swing.JPanel headerPanel1;
    private javax.swing.JLabel lblClases;
    private javax.swing.JLabel lblImgClass1;
    private javax.swing.JLabel lblMaestroNombre;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JScrollPane tblClases;
    // End of variables declaration//GEN-END:variables
}
