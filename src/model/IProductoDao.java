package model;

import java.util.List;

public interface IProductoDao {
	public boolean registrar(Producto producto);
	public List<Producto > obtenerProductos();
	public List<Producto > ordenarProductos();
	
	public boolean actualizar(Producto producto);
	public boolean eliminar(Producto producto);
	public Producto obtenerProducto(int indice);
	
	
	

}
