package services.rest;

import java.util.Map;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import services.dao.NotasDao;

@Path("/notasSeccion")
public class NotasService{
	
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Map<Integer, Integer> mapaMostrarNotasAlumnosSeccion(
			@QueryParam("id_seccion") int id_seccion){
		try {
			return new NotasDao().mapaMostrarNotasAlumnosSeccion(id_seccion);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarNotas(Map<Integer, Integer> notas){
		try {
			new NotasDao().modificarNotas(notas);
			return "Notas modificadas satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
}
