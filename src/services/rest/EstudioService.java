package services.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import services.beans.Estudio;
import services.dao.EstudioDao;


@Path("/estudios")
public class EstudioService {
	
	@Path("/lista")
	@GET
	@Produces("application/json; charset=utf-8")
	public List<Estudio> listaEstudios(){	
		 try {
			 return new EstudioDao().listaEstudios();			 
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
