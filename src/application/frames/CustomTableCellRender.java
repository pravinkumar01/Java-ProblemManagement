package application.frames;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

final class CustomTableCellRender extends JTextArea implements TableCellRenderer{

	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
	               boolean isSelected, boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }

	    if(row % 2 == 0){
	    	setBackground(new java.awt.Color(247,255,255));
	    }else{
	    	setBackground(new java.awt.Color(217,250,248));
	    }

	    setFont(new java.awt.Font("Calibri",0,16));
		setForeground(new java.awt.Color(0,0,0));

	    if (hasFocus) {
	      setBorder( UIManager.getBorder("Table.focusCellHighlightBorder") );
	      if (table.isCellEditable(row, column)) {
	        setForeground( UIManager.getColor("Table.focusCellForeground") );
	        setBackground( UIManager.getColor("Table.focusCellBackground") );
	      }
	    } else {
	      setBorder(new EmptyBorder(1, 2, 1, 2));
	    }

	    this.setText((String)value);
	    this.setToolTipText(value != null ? value.toString() : "");
	    return this;
	  }
}
