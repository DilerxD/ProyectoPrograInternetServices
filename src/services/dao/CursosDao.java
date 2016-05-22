package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;

import services.beans.Curso;
import services.requestrespondes.CursoResponse;


public class CursosDao {
	public List<CursoResponse> listaCursos() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM cursos");
			List<CursoResponse> listaCursos = new LinkedList<>();			
			while(rs.next()){
				int contador=0;
				PreparedStatement ps=conn.prepareStatement("select * from secciones where id_curso=?");
				ps.setInt(1, rs.getInt(1));
				ResultSet rs2=ps.executeQuery();
				while(rs2.next()){
					contador++;
				}
				PreparedStatement ps2=conn.prepareStatement("select * from escuelas where id=?");
				ps2.setInt(1, rs.getInt(4));
				ResultSet rs3=ps2.executeQuery();
				if(rs3.next()){
					listaCursos.add(new CursoResponse(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4),
							rs3.getString(2),
							contador));
				}
				
			}
			conexionDao.desconectarse(conn);
			return listaCursos;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public CursoResponse obtenerCurso(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM cursos WHERE id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				PreparedStatement ps2=conn.prepareStatement("select * from escuelas where id=?");
				ps2.setInt(1, rs.getInt(4));
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					CursoResponse curso = new CursoResponse(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4),
							rs2.getString(2),
							0);
					return curso;
				}				
			}
			conexionDao.desconectarse(conn);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void registrarCurso(Curso curso) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO cursos (nombre, codigo, id_escuela) VALUES (?, ?, ?)");
			ps.setString(1, curso.getNombre());
			ps.setInt(2, curso.getCodigo());
			ps.setInt(3,curso.getId_escuela());
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void modificarCurso(Curso curso) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE cursos set nombre=?, codigo=?, id_escuela=? WHERE id=?");
			ps.setString(1, curso.getNombre());
			ps.setInt(2, curso.getCodigo());
			ps.setInt(3, curso.getId_escuela());
			ps.setInt(4, curso.getId());
			ps.executeUpdate();

			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public void eliminarCurso(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM cursos WHERE id=?");
			
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
