package application.frames;

import javax.swing.table.AbstractTableModel;

final class CustomeTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[][] data;
	private String[] columnNames;

    public CustomeTableModel(String[][] data, String[] columnName) {
        this.data = data;
        this.columnNames = columnName;
    }

    public boolean isCellEditable(int row, int col) {
    	if(col == 13 ||col == 14 ||col == 15 ||col == 16){
    		return true;
    	}else{
    		return false;
    	}

    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
    	if(data == null){
    		return 0;
    	}else{
    		return data.length;
    	}
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}
