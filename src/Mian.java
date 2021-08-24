import controller.ControllerProducto;
import model.ModeloTablaProductos;
import model.Producto;

public class Mian {

	public static void main(String[] args) {
		Producto producto = new Producto( "coco" , 45.6 , 7);
		ControllerProducto controlador = new ControllerProducto();
		controlador.registrar(producto);
		controlador.verProductos();
		
		
		
		
		
		

	}

}
