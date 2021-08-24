package controller;
import java.util.ArrayList;
import java.util.List;


import javax.swing.table.TableModel;

import model.IProductoDao;
import model.ModeloTablaProductos;
import model.Producto;
import model.ProductoDaoImple;
import model.TablaProductos;
import view.ViewProducto;

public class ControllerProducto {
	
	private ViewProducto vista = new ViewProducto();

	public ControllerProducto() {
	}
	public void registrar(Producto producto) {
		IProductoDao dao = new ProductoDaoImple();
		dao.registrar(producto);
		
	}
	
  
	
		
	
	public Producto obtenerProducto(int indice) {
		IProductoDao dao = new ProductoDaoImple();
		dao.obtenerProducto(indice);
		return dao.obtenerProducto(indice);
		
	}
	
	public void verProductos() {
		List<Producto> productos = new ArrayList<Producto>();
		IProductoDao dao = new ProductoDaoImple();
		productos = dao.obtenerProductos();
		vista.verProductos(productos);
	}
	
	public void eliminar(Producto producto) {
		IProductoDao dao = new ProductoDaoImple();
		dao.eliminar(producto);
		
	}
	public void actualizar (Producto producto) {
		IProductoDao dao = new ProductoDaoImple();
		dao.actualizar(producto);
	}
	
	public List<Producto>  ordenarProductos() {
		List<Producto> productosOrdenados = new ArrayList<Producto>();
		IProductoDao dao = new ProductoDaoImple();
		productosOrdenados  = dao.ordenarProductos();
		return productosOrdenados;
		
	}
	
	
		
	

}
