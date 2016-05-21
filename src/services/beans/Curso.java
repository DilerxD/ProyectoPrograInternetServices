package services.beans;

public class Curso {
	
	private int id;
	private String nombre;
	private int codigo;
	private int id_escuela;
	public Curso() {
		super();
	}
	public Curso(int id, String nombre, int codigo, int id_escuela) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.id_escuela = id_escuela;
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getId_escuela() {
		return id_escuela;
	}
	public void setId_escuela(int id_escuela) {
		this.id_escuela = id_escuela;
	}
	
	
	
}
