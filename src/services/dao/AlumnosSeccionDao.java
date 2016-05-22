package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;



public class AlumnosSeccionDao {
	public Map<Integer, Integer> mapaMostrarPertenece(int id_seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		
		try {
			Statement stmt = conn.createStatement();							
			ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos_secciones");
			Map<Integer, Integer> mapaMostrarPertenece= new LinkedHashMap<>();
			while(rs.next()){
				if(id_seccion==rs.getInt(3)){
					mapaMostrarPertenece.put(rs.getInt(2), 1);
				}else{
					mapaMostrarPertenece.put(rs.getInt(2), 0);
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
		String sql3="delete from alumnos_secciones where id_alumno=?";
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
}
