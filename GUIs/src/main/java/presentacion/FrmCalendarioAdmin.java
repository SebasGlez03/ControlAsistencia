/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dto.EventoDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import subsistemaEvento.FachadaEvento;

/**
 *
 * @author limon
 */
public class FrmCalendarioAdmin extends javax.swing.JFrame {
    
    
    /**
     * Creates new form FrmCalendarioAdmin
     */
    public FrmCalendarioAdmin() {
        initComponents();
        
        llenarTablaCarrera(ControlEvento.obtenerEvento());
    }
    
    public void llenarTablaCarrera(List<EventoDTO> listaEvento) {
    DefaultTableModel modeloTabla = (DefaultTableModel) this.tblEvento.getModel();

    // Limpiar la tabla antes de agregar nuevos datos
    if (modeloTabla.getRowCount() > 0) {
        for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
            modeloTabla.removeRow(i);
        }
    }

    // Asegurarnos de que la lista no esté vacía
    if (listaEvento != null && !listaEvento.isEmpty()) {
        listaEvento.forEach(row -> {
            Object[] fila = new Object[5]; // Aquí asumimos que son 5 columnas
            fila[0] = row.getTitulo();
            fila[1] = row.getDescripcion();
            
            // Convertir la fecha a String si es necesario
            fila[2] = row.getFecha() != null ? row.getFecha().toString() : "";  // Aquí, si `Fecha` es Date, convertirla a String
            fila[3] = row.getHoraInicio();
            fila[4] = row.getHoraFinal();

            modeloTabla.addRow(fila);  // Agregar la fila a la tabla
        });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvento = new javax.swing.JTable();
        txtEventos = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        campoTextoTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoTextoDescripcion = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Descripcion", "Fecha", "Hora Inicio", "Hora Final", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEvento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 730, 120));

        txtEventos.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        txtEventos.setText("Administrador de Eventos");
        getContentPane().add(txtEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Titulo.setText("Titulo");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));
        getContentPane().add(campoTextoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 220, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Descripcion");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));
        getContentPane().add(campoTextoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 220, 80));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmCalendarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalendarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalendarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalendarioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCalendarioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField campoTextoDescripcion;
    private javax.swing.JTextField campoTextoTitulo;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEvento;
    private javax.swing.JLabel txtEventos;
    // End of variables declaration//GEN-END:variables
}