package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Profesor;
import services.requestrespondes.ProfesorResponse;


public class ProfesorDao {
	public List<ProfesorResponse> listaProfesores() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM profesores");
			List<ProfesorResponse> listaProfesores = new LinkedList<>();
			while(rs.next()){
				PreparedStatement ps=conn.prepareStatement("select * from estudios where id=?");
				ps.setInt(1, rs.getInt(7));
				ResultSet rs2=ps.executeQuery();
				if(rs2.next()){
					listaProfesores.add(new ProfesorResponse(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7),
							rs2.getString(2)));
				}				
			}
			conexionDao.desconectarse(conn);
			return listaProfesores;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public ProfesorResponse obtenerProfesor(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps1 = conn.prepareStatement(
					"SELECT * FROM profesores WHERE id=?");
			ps1.setInt(1, id);
			
			ResultSet rs = ps1.executeQuery();

			if(rs.next()){
				PreparedStatement ps2=conn.prepareStatement("select * from estudios where id=?");
				ps2.setInt(1, rs.getInt(7));
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					ProfesorResponse profesor = new ProfesorResponse(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getInt(7),
							rs2.getString(2));
					conexionDao.desconectarse(conn);
					return profesor;
				}
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void registrarProfesor(Profesor profesor) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO profesores (nombres,apellido_paterno, apellido_materno,dni,foto_url,id_estudio) VALUES (?, ?, ?, ?, ?, ?)");		
			ps.setString(1, profesor.getNombres());
			ps.setString(2, profesor.getApellido_paterno());
			ps.setString(3, profesor.getApellido_materno());
			ps.setString(4, profesor.getDni());
			ps.setString(5, profesor.getFoto_url());
			ps.setInt(6, profesor.getId_estudio());
			
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void modificarProfesor(Profesor profesor) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE profesores set nombres=?, apellido_paterno=?, apellido_materno=?, dni=?, foto_url=?, id_estudio=? WHERE id=?");
			ps.setString(1, profesor.getNombres());
			ps.setString(2, profesor.getApellido_paterno());
			ps.setString(3, profesor.getApellido_materno());
			ps.setString(4, profesor.getDni());
			ps.setString(5, profesor.getFoto_url());
			ps.setInt(6, profesor.getId_estudio());
			ps.setInt(7, profesor.getId());
			
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void eliminarProfesor(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM profesores WHERE id=?");
			
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
