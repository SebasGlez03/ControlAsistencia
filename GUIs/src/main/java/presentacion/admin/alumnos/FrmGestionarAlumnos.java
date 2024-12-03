/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.admin.alumnos;

import presentacion.admin.usuarios.*;
import dto.UsuarioDTO;
import entidades.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bson.types.ObjectId;
import presentacion.admin.FrmAdminMenu;
import subsistemaUsuario.*;
import utilerias.JButtonCellEditor;
import utilerias.JButtonRenderer;

/**
 *
 * @author PC
 */
public class FrmGestionarAlumnos extends javax.swing.JFrame {

    IUsuario subsUsuario = new FachadaUsuario();

    /**
     * Creates new form FrmEliminarUsuarioTabla
     */
    public FrmGestionarAlumnos() {
        initComponents();
        llenarTablaUsuarios(subsUsuario.obtenerListaUsuarios());
        botonEliminarEnTabla();
        botonEditarEnTabla();
    }

    /**
     * Metodo que llena la tabla de usuarios con la informacion de la base de
     * datos
     *
     * @param listaUsuarios lista de usuarios proveniente de la base de datos.
     */
    public void llenarTablaUsuarios(List<Usuario> listaUsuarios) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblUsuarios.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }

        if (listaUsuarios != null) {
            listaUsuarios.forEach(row -> {
                Object[] fila = new Object[10]; // Eran 7, pero se pusieron 10 para agregar el rol donde no lo vea el usuario
                fila[0] = row.getMatricula();
                fila[1] = row.getNombre();
                fila[2] = row.getApellidoPaterno();
                fila[3] = row.getApellidoMaterno();
                fila[4] = row.getCorreo();
                fila[5] = row.getContrasenia();
                fila[6] = subsUsuario.getRolUsuarioViaObjectId(row.getRol());
                fila[9] = row.getRol(); // Esto no se mostrara al usuario, es solo para utilizarlo en el btn y que obtenga este valor

                modeloTabla.addRow(fila);
            });
        }
    }

    /**
     * Metodo que agrega el boton en la tabla, que a su vez contiene la logica
     * para eliminar el esutidante deseado
     */
    private void botonEliminarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();

                    int matricula = (Integer) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellidoPaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    String apellidoMaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String correo = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
                    String contrasenia = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
                    ObjectId rol = (ObjectId) modeloTabla.getValueAt(filaSeleccionada, 9);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setMatricula(matricula);
                    usuario.setNombre(nombre);
                    usuario.setApellidoPaterno(apellidoPaterno);
                    usuario.setApellidoMaterno(apellidoMaterno);
                    usuario.setCorreo(correo);
                    usuario.setContrasenia(contrasenia);
                    usuario.setRol(rol);

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    System.out.println("Estudiante a eliminar: " + estudiante.toString());
                    int respuesta = JOptionPane.showConfirmDialog(
                            null,
                            "¿Está seguro de que desea eliminar este usuario?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    if (respuesta == JOptionPane.YES_OPTION) {
                        try {
                            subsUsuario.eliminarUsuario(usuario);
                            JOptionPane.showMessageDialog(null, "El usuario se ha eliminado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            modeloTabla.setRowCount(0);
                            llenarTablaUsuarios(subsUsuario.obtenerListaUsuarios());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al eliminar el usuario: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
        };

        TableColumnModel modeloColumnas = this.tblUsuarios.getColumnModel();
        modeloColumnas.getColumn(7).setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(7).setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    /**
     * Metodo que agrega el boton en la tabla, que a su vez contiene la logica
     * para eliminar el esutidante deseado
     */
    private void botonEditarEnTabla() {

        ActionListener onEliminarClickListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén la fila seleccionada
                int filaSeleccionada = tblUsuarios.getSelectedRow();

                if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
                    // Usa el modelo para obtener los datos del estudiante en esa fila
                    DefaultTableModel modeloTabla = (DefaultTableModel) tblUsuarios.getModel();

                    int matricula = (Integer) modeloTabla.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID esté en la columna 0
                    String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellidoPaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    String apellidoMaterno = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String correo = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
                    String contrasenia = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
                    ObjectId rol = (ObjectId) modeloTabla.getValueAt(filaSeleccionada, 9);

                    // Crea un EstudianteDTO usando los datos obtenidos de la fila
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setMatricula(matricula);
                    usuario.setNombre(nombre);
                    usuario.setApellidoPaterno(apellidoPaterno);
                    usuario.setApellidoMaterno(apellidoMaterno);
                    usuario.setCorreo(correo);
                    usuario.setContrasenia(contrasenia);
                    usuario.setRol(rol);

                    FrmModificarAlumnos modificarUsuario = new FrmModificarAlumnos(usuario);
                    modificarUsuario.setVisible(true);
                    dispose();

                    // Aquí puedes implementar la lógica de eliminación o cualquier otra acción
//                    int respuesta = JOptionPane.showConfirmDialog(
//                            null,
//                            "¿Está seguro de que desea modificar este alumno?",
//                            "Confirmar eliminación",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.QUESTION_MESSAGE
//                    );
//
//                    if (respuesta == JOptionPane.YES_OPTION) {
//                        try {
//                            subsUsuario.modificarUsuario(usuario, usuarioModificado);
//                            JOptionPane.showMessageDialog(null, "El usuario se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//                            dispose();
//                            modeloTabla.setRowCount(0);
//                        } catch (Exception ex) {
//                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado al modificar el usuario: " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
                }
            }
        };

        TableColumnModel modeloColumnas = this.tblUsuarios.getColumnModel();
        modeloColumnas.getColumn(8).setCellRenderer(new JButtonRenderer("Modificar"));
        modeloColumnas.getColumn(8).setCellEditor(new JButtonCellEditor("Modificar", onEliminarClickListener));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarUsuario = new javax.swing.JPanel();
        lblEliminarUsuarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarUsuario.setBackground(new java.awt.Color(27, 57, 166));
        agregarUsuario.setForeground(new java.awt.Color(27, 57, 166));

        lblEliminarUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblEliminarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminarUsuarios.setText("Gestionar Usuarios");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Correo", "Contraseña", "Rol", "Eliminar", "Modificar", "IdRol Oculto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(3).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(4).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(5).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(6).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(9).setMinWidth(0);
            tblUsuarios.getColumnModel().getColumn(9).setPreferredWidth(0);
            tblUsuarios.getColumnModel().getColumn(9).setMaxWidth(0);
        }

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(0, 0, 0));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout agregarUsuarioLayout = new javax.swing.GroupLayout(agregarUsuario);
        agregarUsuario.setLayout(agregarUsuarioLayout);
        agregarUsuarioLayout.setHorizontalGroup(
            agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGroup(agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarUsuarioLayout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(lblEliminarUsuarios))
                    .addGroup(agregarUsuarioLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(636, 636, 636)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        agregarUsuarioLayout.setVerticalGroup(
            agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblEliminarUsuarios)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmAgregarAlumno frmAgregarUsuario = new FrmAgregarAlumno();
        frmAgregarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmAdminMenu admMenu = new FrmAdminMenu();
        admMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregarUsuario;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEliminarUsuarios;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
