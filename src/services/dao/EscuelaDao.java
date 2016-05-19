package services.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Escuela;

public class EscuelaDao {
	public List<Escuela> listaEscuelas() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM escuelas");
			List<Escuela> listaEscuelas = new LinkedList<>();
			while(rs.next()){
				listaEscuelas.add(new Escuela(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)));
			}
			conexionDao.desconectarse(conn);
			return listaEscuelas;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}	
}
