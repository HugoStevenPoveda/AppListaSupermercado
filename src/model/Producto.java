package model;

public class Producto {
	private int codigo;
	private String nombre;
	private double precio;
	private int inventario;
	
	//CONSTRUCTOR
	public Producto(int codigo, String nombre, double precio, int inventario) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.inventario = inventario;
	}
	
	public Producto() {
		
	}
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
	public Producto(String nombre, double precio, int inventario) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.inventario = inventario;
		
	}
	//METODOS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario
				+ "]";
	}
	
	
	
	
	

}


