/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion.admin.usuarios;

import dto.UsuarioDTO;
import java.util.HashMap;
import subsistemaUsuario.FachadaUsuario;
import subsistemaUsuario.IUsuario;

import org.bson.types.ObjectId;
import javax.swing.*;

/**
 *
 * @author PC
 */
public class FrmModificarUsuario extends javax.swing.JFrame {

    IUsuario subsUsuario = new FachadaUsuario();
    UsuarioDTO usuarioRecibido = new UsuarioDTO();

    /**
     * Creates new form FrmAgregarUsuario
     */
    public FrmModificarUsuario() {
        initComponents();
        llenarComboBox(comboBoxRol);
    }

    public FrmModificarUsuario(UsuarioDTO usuarioRecibido) {
        initComponents();
        llenarComboBox(comboBoxRol);
        this.usuarioRecibido = usuarioRecibido;

        txtMatricula.setText(String.valueOf(usuarioRecibido.getMatricula()));
        txtNombre.setText(usuarioRecibido.getNombre());
        txtApellidoPaterno.setText(usuarioRecibido.getApellidoPaterno());
        txtApellidoMaterno.setText(usuarioRecibido.getApellidoMaterno());
        txtCorreo.setText(usuarioRecibido.getCorreo());
        txtContrasenia.setText(usuarioRecibido.getContrasenia());

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
        lblAdministrarUsuarios1 = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        lblApellidoPaterno = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        lblRol = new javax.swing.JLabel();
        comboBoxRol = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarUsuario.setBackground(new java.awt.Color(27, 57, 166));
        agregarUsuario.setForeground(new java.awt.Color(27, 57, 166));

        lblAdministrarUsuarios1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblAdministrarUsuarios1.setForeground(new java.awt.Color(255, 255, 255));
        lblAdministrarUsuarios1.setText("Agregar Usuario");

        lblMatricula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        lblMatricula.setText("Matricula");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoPaterno.setText("Apellido Paterno:");

        txtApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoMaterno.setText("Apellido Materno:");

        txtApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasenia.setText("Contraseña:");

        txtContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setText("Rol:");

        comboBoxRol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAceptar.setForeground(new java.awt.Color(0, 0, 0));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout agregarUsuarioLayout = new javax.swing.GroupLayout(agregarUsuario);
        agregarUsuario.setLayout(agregarUsuarioLayout);
        agregarUsuarioLayout.setHorizontalGroup(
            agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(lblAdministrarUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblMatricula))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblNombre))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblApellidoPaterno))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblApellidoMaterno))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblCorreo))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblContrasenia))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblRol))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(comboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(btnCancelar)
                .addGap(34, 34, 34)
                .addComponent(btnAceptar))
        );
        agregarUsuarioLayout.setVerticalGroup(
            agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarUsuarioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblAdministrarUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblMatricula)
                .addGap(6, 6, 6)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblNombre)
                .addGap(6, 6, 6)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblApellidoPaterno)
                .addGap(6, 6, 6)
                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblApellidoMaterno)
                .addGap(6, 6, 6)
                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblCorreo)
                .addGap(6, 6, 6)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblContrasenia)
                .addGap(6, 6, 6)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblRol)
                .addGap(12, 12, 12)
                .addComponent(comboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(agregarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar)))
        );

        getContentPane().add(agregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        try {
            // Crear el mapa para obtener el ObjectId correspondiente
            HashMap<String, ObjectId> objectIdMap = new HashMap<>();
            objectIdMap.put("Alumno", new ObjectId("674b87f4549a4c0c82072f8b"));
            objectIdMap.put("Maestro", new ObjectId("674b87f4549a4c0c82072f8a"));
            objectIdMap.put("Egresado", new ObjectId("674b87f4549a4c0c82072f8d"));
            objectIdMap.put("Admin", new ObjectId("674b87f4549a4c0c82072f8c"));

            // Crear el objeto UsuarioDTO
            UsuarioDTO usuarioModificado = new UsuarioDTO();
            usuarioModificado.setMatricula(Integer.parseInt(txtMatricula.getText()));
            usuarioModificado.setNombre(txtNombre.getText());
            usuarioModificado.setApellidoPaterno(txtApellidoPaterno.getText());
            usuarioModificado.setApellidoMaterno(txtApellidoMaterno.getText());
            usuarioModificado.setCorreo(txtCorreo.getText());
            usuarioModificado.setContrasenia(txtContrasenia.getText()); // Encriptar la contraseña

            // Obtener el rol seleccionado
            String selectedRole = (String) comboBoxRol.getSelectedItem(); // Etiqueta seleccionada
            ObjectId selectedRoleId = objectIdMap.get(selectedRole);      // ObjectId asociado

            // Establecer el rol como el ObjectId en el UsuarioDTO
            usuarioModificado.setRol(selectedRoleId);

            // Confirmación en consola (opcional)
            System.out.println("Usuario creado para modificar: " + usuarioModificado);
            System.out.println("Rol seleccionado: " + selectedRole + " -> ObjectId: " + selectedRoleId);

            subsUsuario.modificarUsuario(usuarioRecibido, usuarioModificado);

            JOptionPane.showMessageDialog(this, "El usuario se ha modificado correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            FrmGestionarUsuarios frmGestionarUsuarios = new FrmGestionarUsuarios();
            frmGestionarUsuarios.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error inesperado: " + e, "Ha ocurrido un Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void llenarComboBox(JComboBox combobox) {

        // Crear un HashMap para asociar etiquetas con ObjectIds
        HashMap<String, ObjectId> objectIdMap = new HashMap<>();
        objectIdMap.put("Alumno", new ObjectId("674b87f4549a4c0c82072f8b"));
        objectIdMap.put("Maestro", new ObjectId("674b87f4549a4c0c82072f8a"));
        objectIdMap.put("Egresado", new ObjectId("674b87f4549a4c0c82072f8d"));
        objectIdMap.put("Admin", new ObjectId("674b87f4549a4c0c82072f8c"));

        // Agregar las claves (etiquetas) del HashMap al JComboBox
        for (String label : objectIdMap.keySet()) {
            combobox.addItem(label);
        }

        // Agregar un listener al JComboBox para manejar selecciones
        combobox.addActionListener(e -> {
            String selectedLabel = (String) combobox.getSelectedItem();
            ObjectId associatedId = objectIdMap.get(selectedLabel);
            System.out.println("Seleccionado: " + selectedLabel);
            System.out.println("ObjectId asociado: " + associatedId);
        });

    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmGestionarUsuarios gestionarUsuarios = new FrmGestionarUsuarios();
        gestionarUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregarUsuario;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboBoxRol;
    private javax.swing.JLabel lblAdministrarUsuarios1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
