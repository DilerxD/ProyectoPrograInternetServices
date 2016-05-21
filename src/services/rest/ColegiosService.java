package services.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import services.beans.Colegio;
import services.dao.ColegiosDao;

@Path("/colegios")
public class ColegiosService {

	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<Colegio> listaColegios(){	
		 try {
			 return new ColegiosDao().listaColegios();			 
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
