package presentacion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocio.tCliente;

public class TablaClientes extends AbstractTableModel{

	private List<tCliente> _clientes;
	private String[] _colNames = {"Id", "Dni", "Nombre", "Direccion", "Activo"};

	// cuando los eventos se cargan inicialmente tambien es onEvent added o hay que añadirlos en el constructor?
	public TablaClientes() {
		_clientes = new ArrayList<tCliente>();	
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	// si no pongo esto no coge el nombre de las columnas
	// this is for the column header
	@Override
	public String getColumnName(int col) {
		return _colNames[col];
	}

	@Override
	// mÃ©todo obligatorio, probad a quitarlo, no compila
	// this is for the number of columns
	public int getColumnCount() {
		return _colNames.length;
	}

	@Override
	// mÃ©todo obligatorio
	// the number of row, like those in the events list
	public int getRowCount() {
		return _clientes == null ? 0 : _clientes.size();
	}

	@Override
	// mÃ©todo obligatorio
	// asÃ­ es como se va a cargar la tabla desde el ArrayList
	// el Ã­ndice del arrayList es el nÃºmero de fila pq en este ejemplo
	// quiero enumerarlos.
	//
	// returns the value of a particular cell
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object s = null;
		switch (columnIndex) {
		case 0:
			s = _clientes.get(rowIndex).getId();
			break;
		case 1:
			s = _clientes.get(rowIndex).getDni();
			break;
		case 2:
			s = _clientes.get(rowIndex).getNombre();
			break;
		case 3:
			s = _clientes.get(rowIndex).getDir();
			break;	
		
		case 4:
			s = _clientes.get(rowIndex).getActivo();
		}
		return s;
	}

	public void mostrarClientes(List<tCliente> clientes) {
		_clientes = clientes;
		fireTableDataChanged();
	}
}
