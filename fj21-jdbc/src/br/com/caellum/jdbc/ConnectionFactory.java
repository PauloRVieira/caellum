package br.com.caellum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezone=true&serverTimezone=UTC", "root", "@2806YoAe");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}