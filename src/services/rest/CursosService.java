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

import services.beans.Curso;
import services.dao.CursosDao;
import services.requestrespondes.CursoResponse;


@Path("/cursos")
public class CursosService {
	
	
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public CursoResponse verCurso(@QueryParam("id") int id) {
		try {
			return new CursosDao().obtenerCurso(id);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<CursoResponse> listaCursos(){
		try {
			return new CursosDao().listaCursos();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@POST
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String agregarCurso(Curso curso){
		try {
			new CursosDao().registrarCurso(curso);
			return "Curso registrado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en el registro";
		}
	}
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarCurso(Curso curso){
		try {
			new CursosDao().modificarCurso(curso);
			return "Curso modificado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
	@DELETE
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String eliminarCurso(
			@QueryParam("id") int id){
		try {
			new CursosDao().eliminarCurso(id);
			return "Curso eliminado satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la eliminación";
		}
	}
	
	
	
}
