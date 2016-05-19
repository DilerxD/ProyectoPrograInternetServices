package services.rest;


import java.util.List;

import javax.servlet.ServletException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import services.beans.Alumno;
import services.dao.AlumnosDAO;


@Path("/alumnos")
public class AlumnosService {
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Alumno verAlumno(

			@QueryParam("id") int id){
			try {
				return new AlumnosDAO().obtenerAlumno(id);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<Alumno> listaAlumnos(){	
		 try {
			 return new AlumnosDAO().listaAlumnos();			 
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@POST
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String agregarAlumno(Alumno alumno){
		try {
			new AlumnosDAO().registrarAlumno(alumno);
			return "Alumno registrado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en el registro";
		}
	}
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarAlumno(Alumno alumno){
		try {
			new AlumnosDAO().modificarAlumno(alumno);
			return "Alumno modificado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
	@DELETE
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String eliminarAlumno(
			@QueryParam("id") int id){
		try {
			new AlumnosDAO().eliminarAlumno(id);
			return "Alumno eliminado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la eliminación";
		}
	}
}
