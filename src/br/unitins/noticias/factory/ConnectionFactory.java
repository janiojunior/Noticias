package br.unitins.noticias.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private ConnectionFactory() {}
	
	public static Connection getInstance() {
		Connection conn = null;
		try {			  
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/noticiadb?"
							+ "useSSL=false&serverTimeZone=UTC", "noticia", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
