package utilerias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * a
 *
 * @hidden
 */
public class JListExample extends JFrame {

    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JTextField textField;
    private JButton addButton;

    public JListExample() {
        setTitle("Ejemplo de JList");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el modelo de la lista y la JList
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        // Crear campo de texto y botón para agregar
        textField = new JTextField(15);
        addButton = new JButton("Agregar");

        // Añadir ActionListener al botón
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    listModel.addElement(text); // Agregar el texto al modelo de la lista
                    textField.setText(""); // Limpiar el campo de texto
                }
            }
        });

        // Configurar el layout
        setLayout(new BorderLayout());
        add(new JScrollPane(list), BorderLayout.CENTER); // Agregar la JList al centro con scroll
        JPanel inputPanel = new JPanel();
        inputPanel.add(textField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.SOUTH); // Panel de entrada en la parte inferior
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JListExample().setVisible(true);
        });
    }
}
