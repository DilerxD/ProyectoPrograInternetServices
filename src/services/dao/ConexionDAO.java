package services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;


public class ConexionDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/db_parcial";
	protected Connection conectarse() throws ServletException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException("Problemas en el driver: " + e.getMessage());
		}
	}
	
	protected void desconectarse(Connection conn) throws ServletException{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Problemas al cerrar conexion a BD: " + e.getMessage());
		}
	}
}
