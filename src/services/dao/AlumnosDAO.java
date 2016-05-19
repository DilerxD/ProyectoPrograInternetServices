package services.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Alumno;



public class AlumnosDAO {
	public List<Alumno> listaAlumnos() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos");
			List<Alumno> listaAlumnos = new LinkedList<>();
			while(rs.next()){
				listaAlumnos.add(new Alumno(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getInt(8)));
			}
			conexionDao.desconectarse(conn);
			return listaAlumnos;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public Alumno obtenerAlumno(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM alumnos WHERE id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				Alumno alumno = new Alumno(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getInt(8));
				conexionDao.desconectarse(conn);
				return alumno;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void registrarAlumno(Alumno alumno) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO alumnos (nombres,apellido_paterno, apellido_materno,dni,foto_url,codigo,id_colegio) VALUES (?, ?, ?, ?, ?, ? ,?)");		
			
			ps.setString(1, alumno.getNombres());
			ps.setString(2, alumno.getApellido_paterno());
			ps.setString(3, alumno.getApellido_materno());
			ps.setString(4, alumno.getDni());
			ps.setString(5, alumno.getFoto_url());
			ps.setInt(6, alumno.getCodigo());
			ps.setInt(7, alumno.getId_colegio());
			
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void modificarAlumno(Alumno alumno) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE alumnos set nombres=?, apellido_paterno=?, apellido_materno=?, dni=?, foto_url=?, codigo=?, id_colegio=? WHERE id=?");
			ps.setString(1, alumno.getNombres());
			ps.setString(2, alumno.getApellido_paterno());
			ps.setString(3, alumno.getApellido_materno());
			ps.setString(4, alumno.getDni());
			ps.setString(5, alumno.getFoto_url());
			ps.setInt(6, alumno.getCodigo());
			ps.setInt(7, alumno.getId_colegio());
			ps.setInt(8, alumno.getId());
			
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void eliminarAlumno(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM alumnos WHERE id=?");
			
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
