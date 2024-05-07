package model.dataBaseManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectToSQL {

	public static Connection getConnection() {
		Connection connection = null;
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto","root","root");
				boolean valida = connection.isValid(50000);
				System.out.println(valida ? "Conexión realizada" : "Conexión fallida");
			} catch (java.sql.SQLException e) {
				System.out.println("Error sql:" + e.getErrorCode());
			}
		}
		return connection;
	}
}
