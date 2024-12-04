/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import dto.MaestroDTO;
import dto.SesionDTO;
import entidades.Alumno;
import entidades.Clase;
import entidades.Maestro;
import entidades.Sesion;
import entidades.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Timer;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import subsistemaMaestro.FachadaMaestro;
import subsistemaMaestro.IMaestro;
import subsistemaSesion.FachadaSesion;
import subsistemaSesion.ISesion;
import subsubsistemaqr.FachadaQR;
import subsubsistemaqr.IQR;

/**
 *
 * @author Ragzard
 */
public class QRClassPanel extends javax.swing.JPanel {

    MainWindow mainWindow;
    InicioPanel inicioPanel;
    Usuario usuario;
    Clase clase;
    ObjectId sesionId;
    IQR iqr = new FachadaQR();
    IMaestro subsMaestro = new FachadaMaestro();
    ISesion subsSesion = new FachadaSesion();

    Timer timer;

    List<Alumno> listaAlumnos = new ArrayList<>();

    /**
     *
     * @param mainwindow
     * @param inicioPanel
     * @param usuario
     * @param clase
     */
    public QRClassPanel(MainWindow mainwindow, InicioPanel inicioPanel, Usuario usuario, Clase clase) {
        initComponents();
        this.usuario = usuario;
        this.clase = clase;
        this.mainWindow = mainwindow;
        this.inicioPanel = inicioPanel;

        lblClassName1.setText(clase.getNombre());

        mostrarQR();
        //listaAlumnos = subsSesion.obtenerSesionAlumnosNoDocumento(obtenerSesionDTO());
        //llenarTablaAlumnos(listaAlumnos);
        this.lblPIN.setText(String.valueOf(iqr.obtenerPIN()));
        iniciarRefrescoTabla();

    }

    public final void llenarTablaAlumnos(List<Alumno> listaAlumnos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaAlumnos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaAlumnos != null) {
            listaAlumnos.forEach(row -> {
                Object[] fila = new Object[4];
                fila[0] = row.getMatricula();
                fila[1] = row.getNombre();
                fila[2] = row.getApellidoPaterno();
                fila[3] = row.getEstadoAsistencia();

                modeloTabla.addRow(fila);
            });
        }

    }

    public final SesionDTO obtenerSesionDTO() {
        Sesion sesion = subsSesion.obtenerSesion(sesionId);

        SesionDTO dto = new SesionDTO();
        dto.setId(sesionId);
        dto.setFecha(sesion.getFecha());
        dto.setIdClase(sesion.getIdClase());
        dto.setMatriculaMaestro(sesion.getMatriculaMaestro());
        dto.setAlumnos(sesion.getAlumnos());

        return dto;
    }

    public final void iniciarRefrescoTabla() {
        timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                List<Alumno> alumnosActualizados = subsSesion.obtenerSesionAlumnosNoDocumento(obtenerSesionDTO());
                SwingUtilities.invokeLater(() -> llenarTablaAlumnos(alumnosActualizados));
                System.out.println("Se actualizo");
            }
        };
        timer.scheduleAtFixedRate(tarea, 0, 5000);
    }

    public final void detenerRefrescoTabla() {
        if (timer != null) {
            timer.cancel(); // Detener el temporizador
            timer = null; // Liberar la referencia
            System.out.println("El refresco de la tabla se ha detenido.");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public MaestroDTO obtenerMaestroDelUsuario(int matricula) {
        return subsMaestro.obtenerMaestro(matricula);
    }

    public Maestro convertirMaestroDTOaEntidad(MaestroDTO dto) {
        Maestro maestro = new Maestro();
        maestro.setMatricula(dto.getMatricula());
        maestro.setNombre(dto.getNombre());
        maestro.setApellidoPaterno(dto.getApellidoPaterno());
        maestro.setApellidoMaterno(dto.getApellidoMaterno());
        maestro.setCorreo(dto.getCorreo());
        maestro.setContrasenia(dto.getContrasenia());
        maestro.setRol(dto.getRol());
        maestro.setMaterias(dto.getMaterias());

        return maestro;
    }

    public ObjectId getSesionId() {
        return sesionId;
    }

    public void setSesionId(ObjectId sesionId) {
        this.sesionId = sesionId;
    }

    private void mostrarQR() {
        iqr.generarQR(clase, convertirMaestroDTOaEntidad(obtenerMaestroDelUsuario(usuario.getMatricula())));
        setSesionId(iqr.obtenerIdSesion());

        try {
            BufferedImage qrImage = ImageIO.read(new File(iqr.obtenerPathQR()));

            ImageIcon qrIcon = new ImageIcon(qrImage);

            imgQR.setIcon(qrIcon);
        } catch (Exception e) {
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Asistencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        ContentPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 410, 490));

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
        detenerRefrescoTabla();
        inicioPanel.setPin(iqr.obtenerPIN());
        inicioPanel.setUsuario(usuario);
        System.out.println("Se regreso el pin: " + iqr.obtenerPIN() + " de la clase QRClassPanel a la clase: " + inicioPanel.getClass());
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
    private javax.swing.JLabel lblImgClass1;
    private javax.swing.JLabel lblPIN;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
