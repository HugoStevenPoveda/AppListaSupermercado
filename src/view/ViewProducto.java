package view;

import java.util.List;

import model.Producto;

public class ViewProducto {
	public void verProducto(Producto producto) {
		System.out.println("produto es " + producto);

	}

	public void verProductos(List<Producto> productos) {
		for (Producto producto : productos) {
			System.out.println("datos del producto" + producto);
		}
	}

}
