package application.frames;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellEditor;

final class CustomeCellEditor extends AbstractCellEditor implements TableCellEditor{

	private static final long serialVersionUID = 1L;

	private String value;
	@Override
	public Object getCellEditorValue() {
		return value;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object data,
			boolean isSelected, int rowIndex, int vColIndex) {
		this.value = (String)data;
		JTextArea area = new JTextArea(value);

		if (isSelected) {
			area.setForeground(table.getSelectionForeground());
			area.setBackground(table.getSelectionBackground());
	    } else {
	    	area.setForeground(table.getForeground());
	    	area.setBackground(table.getBackground());
	    }

	    if(rowIndex % 2 == 0){
	    	area.setBackground(new java.awt.Color(247,255,255));
	    }else{
	    	area.setBackground(new java.awt.Color(217,250,248));
	    }

	    area.setFont(new java.awt.Font("Calibri",0,16));
	    area.setForeground(new java.awt.Color(0,0,0));

	    area.setLineWrap(true);
	    area.setEditable(false);
	    JScrollPane pane = new JScrollPane(area);
	    pane.setToolTipText(value != null ? value.toString() : "");
	    area.setToolTipText(value != null ? value.toString() : "");
	    return pane;
	}
}
