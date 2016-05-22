package services.requestrespondes;

import java.util.Map;

public class RequestAlumnosSeccion {

	private Map<Integer, Integer> mapaPertenece;
	private int id_seccion;
	
	public RequestAlumnosSeccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestAlumnosSeccion(Map<Integer, Integer> mapaPertenece, int id_seccion) {
		super();
		this.mapaPertenece = mapaPertenece;
		this.id_seccion = id_seccion;
	}

	public Map<Integer, Integer> getMapaPertenece() {
		return mapaPertenece;
	}

	public void setMapaPertenece(Map<Integer, Integer> mapaPertenece) {
		this.mapaPertenece = mapaPertenece;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	
	
}
