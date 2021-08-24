package connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection conectar() {
		Connection conexion = null;
		String user = "root";
		String password = "";
		String url = "jdbc:mysql://localhost:3306/almacenreto?user=" + user + "&password=" + password;
		try {

			conexion = DriverManager.getConnection(url);
			if (conexion != null) {
				System.out.println("CONECTADO");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NO CONECTADO SQLException ");

		}

		return conexion;

	}
}
