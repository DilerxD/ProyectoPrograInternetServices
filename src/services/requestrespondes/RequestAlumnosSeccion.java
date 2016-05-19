package services.requestrespondes;

import java.util.Map;

public class RequestAlumnosSeccion {

	private Map<Integer, Boolean> mapaPertenece;
	private int id_seccion;
	
	public RequestAlumnosSeccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestAlumnosSeccion(Map<Integer, Boolean> mapaPertenece, int id_seccion) {
		super();
		this.mapaPertenece = mapaPertenece;
		this.id_seccion = id_seccion;
	}
	public Map<Integer, Boolean> getMapaPertenece() {
		return mapaPertenece;
	}
	public void setMapaPertenece(Map<Integer, Boolean> mapaPertence) {
		this.mapaPertenece = mapaPertence;
	}
	public int getId_seccion() {
		return id_seccion;
	}
	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	
	
}
