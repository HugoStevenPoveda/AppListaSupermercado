package model;



import javax.swing.JTable;

public class TablaProductos {

	// atributo
	private JTable tableProductos;
	private ModeloTablaProductos modeloProductos;

	// Contructor

	public TablaProductos() {
		modeloProductos = new ModeloTablaProductos();
		this.tableProductos = new JTable(modeloProductos);
	}



	public JTable getTablaProducto() {
		return tableProductos;
	}

}
