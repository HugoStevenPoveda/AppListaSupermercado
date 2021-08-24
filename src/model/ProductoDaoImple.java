package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.mysql.Conexion;

public class ProductoDaoImple implements IProductoDao {

	@Override
	public boolean registrar(Producto producto) {
		Connection conexion = null;
		Statement statement = null;
		boolean registrar = false;

		String query = "INSERT INTO productos (nombre ,precio,inventario ) VALUES ( " + "\"" + producto.getNombre()
				+ "\"" + " , " + producto.getPrecio() + " , " + producto.getInventario() + " )";

		try {
			conexion = Conexion.conectar();// Connexion
			statement = conexion.createStatement();
			statement.execute(query);
			registrar = true;
			statement.close();
			conexion.close();
		} catch (SQLException e) {
			System.out.println(" error en productoDaoImple // METODO REGISTRAR");
			e.printStackTrace();

		}
		return registrar;
	}

	@Override
	public List<Producto> obtenerProductos() {
		Connection conexion = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Producto> listaProductos = new ArrayList<Producto>();
		String query = "SELECT * FROM productos ORDER BY codigo";
		try {
			conexion = Conexion.conectar();// Connexion
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Producto producto = new Producto();
				producto.setCodigo(resultSet.getInt(1));
				producto.setNombre(resultSet.getString(2));
				producto.setPrecio(resultSet.getDouble(3));
				producto.setInventario(resultSet.getInt(4));
				listaProductos.add(producto);
			}
			statement.close();
			resultSet.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println(" error en productoDaoImple // METODO obtenerProducto");
			e.printStackTrace();

		}
		return listaProductos;
	}

	public Producto obtenerProducto(int indice) {

		return obtenerProductos().get(indice);

	}

	@Override
	public boolean actualizar(Producto producto) {
		Connection conexion = null;
		Statement statement = null;
		boolean actualizar = false;
		String Query = "UPDATE productos SET nombre=" +"\""  + producto.getNombre() +"\"" + ", precio = " + producto.getPrecio()
				+ ", inventario = " + producto.getInventario() + " WHERE codigo= " + producto.getCodigo() + ";";
		try {
			conexion = Conexion.conectar();// Connexion
			statement = conexion.createStatement();
			statement.execute(Query);
			actualizar = true;

		} catch (SQLException e) {
			System.out.println(" error en productoDaoImple // METODO actulizar ");
			e.printStackTrace();
		}

		return actualizar;
	}

	@Override
	public boolean eliminar(Producto producto) {
		Connection conexion = null;
		Statement statement = null;
		boolean eliminar = false;
		String query = "DELETE FROM productos WHERE codigo = " + producto.getCodigo();
		try {
			conexion = Conexion.conectar();// Connexion
			statement = conexion.createStatement();
			statement.execute(query);
			eliminar = true;

		} catch (SQLException e) {
			System.out.println("error clase ProductoDaoImple / metdo eliminar");
			e.printStackTrace();
		}
		return eliminar;
	}

	@Override
	public List<Producto> ordenarProductos() {
		Connection conexion = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Producto> listaProductosOrdenada = new ArrayList<Producto>();
		String query = "SELECT nombre ,precio FROM productos ORDER BY precio DESC";
		try {
			conexion = Conexion.conectar();// Connexion
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Producto producto = new Producto();
				
				producto.setNombre(resultSet.getString(1));
				producto.setPrecio(resultSet.getDouble(2));
				
				listaProductosOrdenada.add(producto);
			}
			statement.close();
			resultSet.close();
			conexion.close();

		} catch (SQLException e) {
			System.out.println(" error en productoDaoImple // METODO ordenaProducto");
			e.printStackTrace();

		}
		return listaProductosOrdenada;
		
	}

}
