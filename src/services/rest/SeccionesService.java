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

import services.beans.Seccion;
import services.dao.SeccionDao;
import services.requestrespondes.SeccionResponse;

@Path("/secciones")
public class SeccionesService {
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public SeccionResponse verSeccion(
			@QueryParam("id") int id){
		try {
			return new SeccionDao().obtenerSeccion(id);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<SeccionResponse> listaSecciones(){
		try {
			return new SeccionDao().listaSecciones();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@POST
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String agregarSeccion(Seccion seccion){
		try {
			new SeccionDao().registrarSeccion(seccion);
			return "Seccion registrada satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en el registro";
		}
	}
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarSeccion(Seccion seccion){
		try {
			new SeccionDao().modificarSeccion(seccion);
			return "Sección modificada satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
	@DELETE
	@Consumes("text/plain; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String eliminarSeccion(
			@QueryParam("id") int id){
		try {
			new SeccionDao().eliminarSeccion(id);
			return "Sección eliminada satisfactoriamente";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la eliminación";
		}
	}
}
