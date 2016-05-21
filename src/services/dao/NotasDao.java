package services.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;





public class NotasDao {
	public Map<Integer, Integer> mapaMostrarNotasAlumnosSeccion(int id_seccion) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		String sql1= "select * from alumnos_secciones where id_seccion=?";
		String sql2= "SELECT * FROM notas where id_alumno_seccion=?";
		Map<Integer, Boolean> mapaMostrarPertenece=new AlumnosSeccionDao().mapaMostrarPertenece(id_seccion);
		try {
			Map<Integer, Integer> mapaNotasAlumnosSeccion= new LinkedHashMap<>();
			PreparedStatement ps=conn.prepareStatement(sql1);
			ps.setInt(1, id_seccion);
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()){
				ps=conn.prepareStatement(sql2);
				ps.setInt(1, rs1.getInt(1));
				ResultSet rs2=ps.executeQuery();
				while(rs2.next()){
					if(mapaMostrarPertenece.get(rs1.getInt(2))==true){
						mapaNotasAlumnosSeccion.put(rs1.getInt(2), rs2.getInt(3));
					}				
				}
			}			
			conexionDao.desconectarse(conn);
			return mapaNotasAlumnosSeccion;
		} catch (SQLException e) {
			e.printStackTrace();
			conexionDao.desconectarse(conn);
			throw new ServletException("Error SQL: " + e.getMessage());
		}
	}	
	
	
	public void modificarNotas(Map<Integer, Integer> notas) throws ServletException{
		ConexionDAO conexionDao = new ConexionDAO();
		Connection conn = conexionDao.conectarse();
		String sql1="select * from notas where id_alumno_seccion=?";
		String sql2="INSERT INTO notas (id_alumno_seccion, nota) VALUES (?, ?)";
		String sql3="UPDATE notas set nota=? WHERE id_alumno_seccion=?";
		
		try {
			PreparedStatement ps1 = null;
			ps1 = conn.prepareStatement(sql1);
			for(Entry<Integer, Integer> mapita : notas.entrySet()){
				ps1.setInt(1,mapita.getKey());
				ResultSet rs= ps1.executeQuery();
				if(!(rs.next())){
					PreparedStatement ps2 = conn.prepareStatement(sql2);
					ps2.setInt(1, mapita.getKey());
					ps2.setInt(2, mapita.getValue());
					ps2.executeUpdate();
				}else{
					PreparedStatement ps3 = conn.prepareStatement(sql3);
					ps3.setInt(1, mapita.getValue());
					ps3.setInt(2, mapita.getKey());
					ps3.executeUpdate();
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
