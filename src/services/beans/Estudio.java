package services.beans;

public class Estudio {
	private int id;
	private String nombre;
	private String mencion;
	public Estudio() {
		super();
	}
	public Estudio(int id, String nombre, String mencion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mencion = mencion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMencion() {
		return mencion;
	}
	public void setMencion(String mencion) {
		this.mencion = mencion;
	}
	
	
}
