package services.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import services.beans.Escuela;
import services.dao.EscuelaDao;

@Path("/escuelas")
public class EscuelasService {
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<Escuela> listaEscuelas(){	
		 try {
			 return new EscuelaDao().listaEscuelas();			 
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
