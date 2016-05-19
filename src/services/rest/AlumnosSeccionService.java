package services.rest;

import java.util.Map;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import services.dao.AlumnosSeccionDao;
import services.requestrespondes.RequestAlumnosSeccion;

@Path("/alumnosSeccion")
public class AlumnosSeccionService{
	
	@GET
	@Consumes("text/plain; charset=utf-8")
	@Produces("application/json; charset=utf-8")
	public Map<Integer, Boolean> mapaMostrarPertenece(
			@QueryParam("id_seccion") int id_seccion){
		try {
			return new AlumnosSeccionDao().mapaMostrarPertenece(id_seccion);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	
	@PUT
	@Consumes("application/json; charset=utf-8")
	@Produces("text/plain; charset=utf-8")
	public String modificarAlumnosSeccion(RequestAlumnosSeccion requestAs){
		try {
			new AlumnosSeccionDao().modficarAlumnosSeccion(requestAs.getMapaPertenece(), requestAs.getId_seccion());
			return "Alumnos de la sección correctamente modificados";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Hubo un error en la modificación";
		}
	}
}
