package utilerias;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 * a
 *
 * @hidden
 */
public class JButtonCellEditor implements TableCellEditor {

    private final JButton button;
    private int row;
    private ActionListener actionListener;

    public JButtonCellEditor(String text, ActionListener actionListener) {
        this.button = new JButton(text);
        this.actionListener = actionListener;
        this.button.addActionListener((ActionEvent evt) -> {
            this.actionListener.actionPerformed(
                    new ActionEvent(this.button, ActionEvent.ACTION_PERFORMED, this.row + "")
            );
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return this.button;
    }

    @Override
    public Object getCellEditorValue() {
        return true;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
    }
}
