package services.beans;

public class Colegio {
	private int id;
	private String nombre;
	private int id_distrito;
	public Colegio() {
		super();
	}
	public Colegio(int id, String nombre, int id_distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_distrito = id_distrito;
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
	public int getId_distrito() {
		return id_distrito;
	}
	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}
	
	
}
