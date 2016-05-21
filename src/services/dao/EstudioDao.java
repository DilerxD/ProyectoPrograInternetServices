package services.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Estudio;

public class EstudioDao {
	public List<Estudio> listaEstudios() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM estudios");
			List<Estudio> listaEstudios = new LinkedList<>();
			while(rs.next()){
				listaEstudios.add(new Estudio(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)));
			}
			conexionDao.desconectarse(conn);
			return listaEstudios;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}	
}
