package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Seccion;

public class SeccionDao {
	public List<Seccion> listaSecciones() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM secciones");
			List<Seccion> listaSecciones = new LinkedList<>();
			while(rs.next()){
				listaSecciones.add(new Seccion(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4)));
			}
			conexionDao.desconectarse(conn);
			return listaSecciones;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public Seccion obtenerSeccion(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM secciones WHERE id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Seccion seccion = new Seccion(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getInt(4));
				conexionDao.desconectarse(conn);
				return seccion;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void registrarSeccion(Seccion seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO secciones (codigo, id_curso, id_profesor) VALUES (?, ?, ?)");
			ps.setInt(1, seccion.getCodigo());
			ps.setInt(2, seccion.getId_curso());
			ps.setInt(3, seccion.getId_profesor());
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void modificarSeccion(Seccion seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE secciones set codigo=?, id_curso=?, id_profesor=? WHERE id=?");
			ps.setInt(1, seccion.getCodigo());
			ps.setInt(2, seccion.getId_curso());
			ps.setInt(3, seccion.getId_profesor());	
			ps.setInt(4, seccion.getId());
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void eliminarSeccion(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM secciones WHERE id=?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}	
}
