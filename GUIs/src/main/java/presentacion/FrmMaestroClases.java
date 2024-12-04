/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import dto.UsuarioDTO;
import entidades.Clase;
import entidades.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bson.types.ObjectId;
import subsistemaMaestro.FachadaMaestro;
import subsistemaMaestro.IMaestro;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author Ragzard
 */
public class FrmMaestroClases extends javax.swing.JPanel {

    MainWindow mainWindow;
    InicioPanel inicioPanel;
    Usuario usuario;

    IMaestro subsMaestro = new FachadaMaestro();

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

        lblMaestroNombre.setText(usuario.getNombre() + " " + usuario.getApellidoPaterno());
        lblMatricula.setText(String.valueOf(usuario.getMatricula()));

        llenarTablaClases(subsMaestro.obtenerMateriasImpartidasMaestro(usuario.getMatricula()));
        botonMostrarQR();

    }

    public final void llenarTablaClases(List<Clase> listaClases) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblClases.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaClases != null) {
            listaClases.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getNombre();
                fila[1] = row.getId();
                fila[2] = row.getSemestre();

                modeloTabla.addRow(fila);
            });
        }

    }

    /**
     * Metodo que agrega el boton en la tabla, que a su vez contiene la logica
     * para eliminar el esutidante deseado
     */
    private void botonMostrarQR() {

        ActionListener onMostrarQRClick = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblClases.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblClases.getModel();

                    String nombreClase = (String) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    ObjectId idClase = (ObjectId) modeloTabla.getValueAt(filaSeleccionada, 1);
                    int semestreClaseImpartida = (Integer) modeloTabla.getValueAt(filaSeleccionada, 2);

                    Clase clase = new Clase(nombreClase, semestreClaseImpartida);
                    clase.setId(idClase);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    QRClassPanel qrClass = new QRClassPanel(mainWindow, inicioPanel, usuario, clase);
                    mainWindow.changeContentPane(qrClass);

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblClases.getColumnModel();
        modeloColumnas.getColumn(3).setCellRenderer(new JButtonRenderer("Mostrar QR"));
        modeloColumnas.getColumn(3).setCellEditor(new JButtonCellEditor("Mostrar QR", onMostrarQRClick));
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
        JscrollPane = new javax.swing.JScrollPane();
        tblClases = new javax.swing.JTable();

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

        tblClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Clase", "idClase", "semestreClase", "QR Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClases.setRowHeight(40);
        JscrollPane.setViewportView(tblClases);
        if (tblClases.getColumnModel().getColumnCount() > 0) {
            tblClases.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblClases.getColumnModel().getColumn(1).setMinWidth(0);
            tblClases.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblClases.getColumnModel().getColumn(1).setMaxWidth(0);
            tblClases.getColumnModel().getColumn(2).setMinWidth(0);
            tblClases.getColumnModel().getColumn(2).setPreferredWidth(0);
            tblClases.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        ContentPanel.add(JscrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 690, 460));

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturn1MouseClicked
        mainWindow.changeContentPane(inicioPanel);
        inicioPanel.setUsuario(usuario);
    }//GEN-LAST:event_btnReturn1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel ContentPanel;
    private javax.swing.JLabel ItsonLogo1;
    private javax.swing.JScrollPane JscrollPane;
    private javax.swing.JLabel btnReturn1;
    private javax.swing.JPanel headerPanel1;
    private javax.swing.JLabel lblClases;
    private javax.swing.JLabel lblImgClass1;
    private javax.swing.JLabel lblMaestroNombre;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JTable tblClases;
    // End of variables declaration//GEN-END:variables
}
