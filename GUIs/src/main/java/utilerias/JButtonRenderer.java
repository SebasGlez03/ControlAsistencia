package utilerias;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * a
 *
 * @hidden
 */
public class JButtonRenderer implements TableCellRenderer {

    private final JButton button;

    public JButtonRenderer(String text) {
        this.button = new JButton(text);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this.button;
    }

}
