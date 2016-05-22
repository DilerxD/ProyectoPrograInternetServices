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
import services.requestrespondes.SeccionResponse;

public class SeccionDao {
	public List<SeccionResponse> listaSecciones() throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM secciones");
			List<SeccionResponse> listaSecciones = new LinkedList<>();			
			while(rs.next()){
				int contador=0;
				PreparedStatement ps=conn.prepareStatement("select * from alumnos_secciones where id_seccion=?");
				ps.setInt(1, rs.getInt(1));
				ResultSet rs2=ps.executeQuery();
				while(rs2.next()){
					contador++;
				}
				PreparedStatement ps4=conn.prepareStatement("select * from profesores where id=?");
				ps4.setInt(1, rs.getInt(4));
				ResultSet rs5=ps4.executeQuery();
				if(rs5.next()){
					PreparedStatement ps2=conn.prepareStatement("select * from cursos where id=?");
					ps2.setInt(1, rs.getInt(3));
					ResultSet rs3=ps2.executeQuery();
					if(rs3.next()){
						PreparedStatement ps3=conn.prepareStatement("select * from escuelas where id=?");
						ps3.setInt(1, rs3.getInt(4));
						ResultSet rs4=ps3.executeQuery();
						if(rs4.next()){
							listaSecciones.add(new SeccionResponse(
									rs.getInt(1),
									rs.getInt(2),
									rs.getInt(3),
									rs.getInt(4),
									rs3.getString(2),								
									rs4.getString(2),
									contador,
									rs5.getString(2) + " "+rs5.getString(3)+ " "+rs5.getString(4)));
						}
					}
				}
				
				
				
			}
			conexionDao.desconectarse(conn);
			return listaSecciones;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	
	public SeccionResponse obtenerSeccion(int id) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM secciones WHERE id=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				PreparedStatement ps4=conn.prepareStatement("select * from profesores where id=?");
				ps4.setInt(1, rs.getInt(4));
				ResultSet rs5=ps4.executeQuery();
				if(rs5.next()){
					PreparedStatement ps2=conn.prepareStatement("select * from cursos where id=?");
					ps2.setInt(1, rs.getInt(3));
					ResultSet rs3=ps2.executeQuery();
					if(rs3.next()){
						SeccionResponse seccion = new SeccionResponse(
								rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getInt(4),
								rs3.getString(2),								
								"",
								0,
								rs5.getString(2) + " "+rs5.getString(3)+ " "+rs5.getString(4));
						conexionDao.desconectarse(conn);
						return seccion;
					}
				}
				
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
