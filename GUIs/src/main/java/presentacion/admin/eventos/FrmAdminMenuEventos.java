/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.admin.eventos;

import dto.EventoDTO;
import entidades.Evento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import presentacion.admin.FrmAdminMenu;
import subsistemaEvento.FachadaEvento;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author limon
 */
public class FrmAdminMenuEventos extends javax.swing.JFrame {

    FachadaEvento fachadaEvento = new FachadaEvento(); // Connect to your Evento facade

    public FrmAdminMenuEventos() {
        initComponents();
        
        botonEliminarEnTabla();
        botonEditarEnTabla();
        llenarTablaEventos(fachadaEvento.obtenerListaEventos()); // Populate table with events
    }

    public void llenarTablaEventos(List<Evento> listaEventos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblEvento.getModel();
        
        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        
        if (listaEventos != null) {
            listaEventos.forEach(row -> {
                Object[] fila = new Object[6]; // Adjust the columns based on Evento's properties
                fila[0] = row.getTitulo();
                fila[1] = row.getDescripcion();
                fila[2] = row.getFechaInicio();
                fila[3] = row.getFechaFinal();
                fila[4] = row.getHoraInicio();
                fila[5] = row.getHoraFinal();
                fila[6] = row.getCampus();
                fila[7] = row.getCategoria();
                
                
                
                modeloTabla.addRow(fila);
            });
        }
    }

    private void botonEliminarEnTabla() {
        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblCarrera.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos de la carrera en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblCarrera.getModel();

                    Long idCarrera = (Long) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombreCarrera = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    Date tiempoDiario = (Date) modeloTabla.getValueAt(filaSeleccionada, 2);
                    

                    // Crea un carreraDTO usando los datos obtenidos de la fila
                    
                    CarreraDTO carrera = new CarreraDTO();
                    carrera.setId(idCarrera);
                    carrera.setNombre(nombreCarrera);
                    carrera.setTiempoDiario(tiempoDiario);
        
                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    System.out.println("Carrera a eliminar: " + carrera.toString());
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro de que desea eliminar esta Carrera?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            FachadaPersistencia.eliminarEvento(evento);
                            JOptionPane.showMessageDialog(null, "La Carrera se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            FrmAdminMenuEventos frm = new FrmAdminMenuEventos();
                            frm.setVisible(true);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar la carrera: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblCarrera.getColumnModel();
        modeloColumnas.getColumn(4).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(4).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void botonEditarEnTabla() {
     ActionListener onEditarClickListener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
             // Obtén la fila seleccionada
             int filaSeleccionada = tblEvento.getSelectedRow();

             if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                 // Usa el modelo para obtener los datos de la fila seleccionada
                 DefaultTableModel modeloTabla = (DefaultTableModel) tblEvento.getModel();

                 // Asigna los valores de la fila seleccionada a las variables del evento
                 
                 String titulo = (String) modeloTabla.getValueAt(filaSeleccionada, 0); // Titulo en la columna 1
                 String descripcion = (String) modeloTabla.getValueAt(filaSeleccionada, 1); // Descripción en la columna 2
                 Date fechaInicioDate = (Date) modeloTabla.getValueAt(filaSeleccionada, 2); // Fecha de inicio en la columna 3
                 Date fechaFinDate = (Date) modeloTabla.getValueAt(filaSeleccionada, 3); // Fecha de finalización en la columna 4
                 String horaInicio = (String) modeloTabla.getValueAt(filaSeleccionada, 4); // Hora de inicio en la columna 5
                 String horaFin = (String) modeloTabla.getValueAt(filaSeleccionada, 5); // Hora de finalización en la columna 6
                 String campus = (String) modeloTabla.getValueAt(filaSeleccionada, 6); // Campus en la columna 7
                 String categoria = (String) modeloTabla.getValueAt(filaSeleccionada, 7); // Categoría en la columna 8

                 // Crea el objeto EventoDTO con los valores obtenidos de la tabla
                 EventoDTO evento = new EventoDTO();
                
                 evento.setTitulo(titulo);
                 evento.setDescripcion(descripcion);
                 evento.setFechaInicio(fechaInicioDate);
                 evento.setFechaFinal(fechaFinDate);
                 evento.setHoraInicio(horaInicio);
                 evento.setHoraFinal(horaFin);
                 evento.setCampus(campus);
                 evento.setCategoria(categoria);

                 // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
                    System.out.println("Evento a eliminar: " + evento.toString());
                    FrmEditarEvento frmEAPU = new FrmEditarEvento(evento);
                    frmEAPU.setVisible(true);
             }
         }
     };

     // Establece el editor y renderer del botón de la columna "Editar"
     TableColumnModel modeloColumnas = this.tblEvento.getColumnModel();
     modeloColumnas.getColumn(9).setCellRenderer(new JButtonRenderer("Editar"));
     modeloColumnas.getColumn(9).setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));
 }

       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvento = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Gestionar Evento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(17, 109, 188));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, 120, 40));

        tblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Descripcion", "Fecha inicio", "Fecha fin", "Hora inicio", "Hora fin", "Campus", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEvento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 930, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmAdminMenu adminMenu = new FrmAdminMenu();
        adminMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmAgregarEvento agregarEvento = new FrmAgregarEvento();
        agregarEvento.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdminMenuEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenuEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenuEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdminMenuEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdminMenuEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEvento;
    // End of variables declaration//GEN-END:variables
}
