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

import services.beans.Profesor;
import services.dao.ProfesorDao;

@Path("/profesores")
public class ProfesoresService {
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Profesor verProfesor(
			@QueryParam("id") int id){
		try {
			return new ProfesorDao().obtenerProfesor(id);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<Profesor> listaProfesores(){
		try {
			return new ProfesorDao().listaProfesores();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@POST
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String agregarProfesor(Profesor profesor){
		try {
			new ProfesorDao().registrarProfesor(profesor);
			return "Profesor registrado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en el registro";
		}
	}
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarProfesor(Profesor profesor){
		try {
			new ProfesorDao().modificarProfesor(profesor);
			return "Profesor modificado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
	@DELETE
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String eliminarProfesor(
			@QueryParam("id") int id){
		try {
			new ProfesorDao().eliminarProfesor(id);
			return "Profesor eliminado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la eliminación";
		}
	}
}
