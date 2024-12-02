/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import entidades.Evento;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import persistencia.FachadaPersistencia;

/**
 *
 * @author limon
 */
public class FrmCalendario extends javax.swing.JFrame {

    
    private List<Evento> eventos;
    private FachadaPersistencia fachada;
    private int paginaActual = 0; // Página inicial
    private int eventosPorPagina = 4; // Número de eventos por página
    private List<Evento> eventosFiltrados; // Eventos filtrados por mes y año
    /**
     * Creates new form FrmCalendario
     */
    public FrmCalendario() {
        initComponents();
        
        fachada = new FachadaPersistencia();
        eventos = fachada.obtenerTodosLosEventos(); // Método que retorna todos los eventos
        cargarEventosIniciales(); // Cargar eventos en el frame
        configurarListeners(); // Configurar interacciones
       
    btnAtras.addActionListener(evt -> paginaAnterior());
    btnSiguiente.addActionListener(evt -> siguientePagina());
    }

    
    private void cargarEventosIniciales() {
        actualizarEventos();
    }

    // Método para configurar los listeners
    private void configurarListeners() {
        monthChooser.addPropertyChangeListener("month", e -> actualizarEventos());
        yearChooser.addPropertyChangeListener("year", e -> actualizarEventos());
    }

    // Filtrar eventos por mes y año
    private void actualizarEventos() {
         // Filtrar eventos por mes y año
        int mesSeleccionado = monthChooser.getMonth();  // Enero = 0
        int anioSeleccionado = yearChooser.getYear();

        eventosFiltrados = eventos.stream()
                .filter(evento -> {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(evento.getFechaInicio());  // Usamos la fecha de inicio
                    return cal.get(Calendar.MONTH) == mesSeleccionado &&
                           cal.get(Calendar.YEAR) == anioSeleccionado;
                })
                .collect(Collectors.toList());

        // Reseteamos la página a la primera cuando cambiamos de mes/año
        paginaActual = 0;

        // Mostrar los eventos filtrados en el panel
        mostrarEventosEnPanel();
    }

    private void mostrarEventosEnPanel() {
        // Limpiar el panel de eventos
        panelEventos.removeAll();

        // Calcular el índice de inicio y fin de los eventos a mostrar en la página actual
        int inicio = paginaActual * eventosPorPagina;
        int fin = Math.min(inicio + eventosPorPagina, eventosFiltrados.size());  // Evitar desbordamiento de la lista

        // Configurar el layout de los eventos
        panelEventos.setLayout(new BoxLayout(panelEventos, BoxLayout.Y_AXIS));

        // Agregar los eventos filtrados de la página actual al panel
        for (int i = inicio; i < fin; i++) {
            Evento evento = eventosFiltrados.get(i);

            // Crear y agregar el JLabel para el título del evento
            JLabel lblTitulo = new JLabel("Título: " + evento.getTitulo());
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
            lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Crear y agregar el JLabel para los detalles del evento
            JLabel lblDetalles = new JLabel(String.format(
                "<html><b>Descripción:</b> %s<br><b>Fecha Inicio:</b> %tY/%tm/%td<br>"
                + "<b>Fecha Fin:</b> %tY/%tm/%td<br><b>Hora:</b> %s - %s<br>"
                + "<b>Campus:</b> %s<br><b>Categoría:</b> %s</html>",
                evento.getDescripcion(),
                evento.getFechaInicio(), evento.getFechaInicio(), evento.getFechaInicio(),
                evento.getFechaFinal(), evento.getFechaFinal(), evento.getFechaFinal(),
                evento.getHoraInicio(), evento.getHoraFinal(),
                evento.getCampus(), evento.getCategoria()
            ));
            lblDetalles.setFont(new Font("Arial", Font.PLAIN, 12));
            lblDetalles.setAlignmentX(Component.LEFT_ALIGNMENT);

            // Agregar los elementos al panel
            panelEventos.add(lblTitulo);
            panelEventos.add(lblDetalles);
            panelEventos.add(Box.createRigidArea(new Dimension(0, 10)));  // Espaciado entre eventos

            // Agregar un separador después de cada evento (excepto el último)
            if (i < fin - 1) {
                JSeparator separator = new JSeparator();
                separator.setPreferredSize(new Dimension(panelEventos.getWidth(), 1));  // Establecer el grosor del separador
                panelEventos.add(separator);
            }
        }

        // Actualizar la interfaz gráfica (revalidar y repintar el panel)
        panelEventos.revalidate();
        panelEventos.repaint();

    // Actualizar los botones de navegación (habilitar/deshabilitar según sea necesario)
    actualizarBotones();
    }

    // Función para habilitar o deshabilitar los botones de navegación
    private void actualizarBotones() {
        // Deshabilitar el botón "Atras" si estamos en la primera página
        btnAtras.setEnabled(paginaActual > 0);

        // Deshabilitar el botón "Siguiente" si no hay más páginas por mostrar
        btnSiguiente.setEnabled((paginaActual + 1) * eventosPorPagina < eventosFiltrados.size());
    }
    
    private void siguientePagina() {
        if ((paginaActual + 1) * eventosPorPagina < eventosFiltrados.size()) {
            paginaActual++;  // Incrementar la página actual
            mostrarEventosEnPanel();  // Actualizar los eventos en el panel
        }
    }
  
    // Método para regresar a la página anterior
    private void paginaAnterior() {
        if (paginaActual > 0) {
            paginaActual--;  // Disminuir la página actual
            mostrarEventosEnPanel();  // Actualizar los eventos en el panel
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

        calendario = new javax.swing.JLabel();
        monthChooser = new com.toedter.calendar.JMonthChooser();
        yearChooser = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelEventos = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnRegresar = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calendario.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        calendario.setForeground(new java.awt.Color(255, 255, 255));
        calendario.setText("Calendario");
        getContentPane().add(calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        monthChooser.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(monthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        yearChooser.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(yearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Año:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mes:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        panelEventos.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(panelEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 530, 490));

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 690, -1, -1));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 690, -1, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReturn.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frm.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here
        
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(FrmCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCalendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCalendario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel calendario;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JMonthChooser monthChooser;
    private javax.swing.JPanel panelEventos;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables
}
