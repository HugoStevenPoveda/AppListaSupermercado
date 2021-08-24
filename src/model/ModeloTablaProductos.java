package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ATRIBUTOS

	private List<Producto> productos;
	private String[][] productosOject;
	private ProductoDaoImple listaProductos = new ProductoDaoImple() ;

	
	public ModeloTablaProductos() {
		this.productos = listaProductos.obtenerProductos();
		
	}

	
	// DEFINE NOMBRE DE CAMPOS
	private String[] nombreColumnas = { "Nombre", "Precio", "Imnventario" };
	
    //DEFINE OBJECTO QUE SIRVE DE MODELO
	
	


	public void llenarproductosOject(List<Producto> productos) {

		int cantidaProducto = productos.size();
		productosOject = new String[cantidaProducto][nombreColumnas.length];

		for (int i = 0; i < cantidaProducto ; i++) {

			productosOject[i][0] = productos.get(i).getNombre();
			productosOject[i][1] = String.valueOf(productos.get(i).getPrecio());
			productosOject[i][2] = String.valueOf(productos.get(i).getInventario());
		}

	}

	@Override
	public int getRowCount() {

		return productos.size();
	}

	@Override
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		llenarproductosOject(productos);
		return productosOject[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return nombreColumnas[column];
	}
}
