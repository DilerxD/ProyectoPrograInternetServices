package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;

import services.beans.AlumnoSeccion;
import services.requestrespondes.AlumnoResponse;



public class AlumnosSeccionDao {
	public Map<Integer, Integer> mapaMostrarPertenece(int id_seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		List<AlumnoResponse> listaAlumnos=new AlumnosDAO().listaAlumnos();
		Map<Integer, Integer> mapaMostrarPertenece= new LinkedHashMap<>();
		for(AlumnoResponse alumno : listaAlumnos){
			mapaMostrarPertenece.put(alumno.getId(), 0);
		}
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos_secciones");			
			
			while(rs.next()){
				if(id_seccion==rs.getInt(3)){
					mapaMostrarPertenece.put(rs.getInt(2), 1); //1 Si pertenece a la seccion
				}else{
					mapaMostrarPertenece.put(rs.getInt(2), 0); //0 No pertenece a la seccion
				}				
			}
			conexionDao.desconectarse(conn);
			return mapaMostrarPertenece;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	public void modficarAlumnosSeccion(Map<Integer,Integer> mapaPertenece, int id_seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		String sql1="Select * from alumnos_secciones where id_alumno=? and id_seccion=?";
		String sql2="INSERT INTO alumnos_secciones (id_alumno, id_seccion) VALUES (?, ?)";
		String sql3="delete from alumnos_secciones where id_alumno=? and id_seccion=?";
		try {			
			PreparedStatement ps = null;		
			
			for(Entry<Integer,Integer> mapita : mapaPertenece.entrySet()){
				if(mapita.getValue()==1){
					ps = conn.prepareStatement(sql1);
					ps.setInt(1, mapita.getKey());
					ps.setInt(2, id_seccion);
					ResultSet rs=ps.executeQuery();
					
					if(!(rs.next())){
						ps = conn.prepareStatement(sql2);
						ps.setInt(1, mapita.getKey());
						ps.setInt(2, id_seccion);
						ps.executeUpdate();
					}					
					
				}else if(mapita.getValue()==0){
					ps = conn.prepareStatement(sql3);
					ps.setInt(1, mapita.getKey());
					ps.setInt(2, id_seccion);
					ps.executeUpdate();	
				}
			}			
			conexionDao.desconectarse(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
	public List<AlumnoSeccion> listaAlumnoSeccion (int id_seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		List<AlumnoSeccion> listaAlumnoSeccion=new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM alumnos_secciones where id_seccion=?");							
			ps.setInt(1, id_seccion);
			ResultSet rs = ps.executeQuery();		
			while(rs.next()){
				PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM alumnos where id=?");							
				ps2.setInt(1, rs.getInt(2));
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()){
					AlumnoSeccion alumnoSeccion=new AlumnoSeccion(
							rs.getInt(1),
							rs.getInt(2),
							rs.getInt(3),
							rs2.getInt(7),
							rs2.getString(3),
							rs2.getString(4),
							rs2.getString(2));
					listaAlumnoSeccion.add(alumnoSeccion);
				}
			}
			conexionDao.desconectarse(conn);
			return listaAlumnoSeccion;
			
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}
}
