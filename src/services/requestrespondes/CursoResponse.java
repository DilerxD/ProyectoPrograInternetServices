package services.requestrespondes;

public class CursoResponse {
	private int id;
	private String nombre;
	private int codigo;
	private int id_escuela;
	private String escuela;
	private int cantidadSecciones;
	public CursoResponse(int id, String nombre, int codigo, int id_escuela, String escuela, int cantidadSecciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.id_escuela = id_escuela;
		this.escuela = escuela;
		this.cantidadSecciones = cantidadSecciones;
	}
	public CursoResponse() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public int getCantidadSecciones() {
		return cantidadSecciones;
	}
	public void setCantidadSecciones(int cantidadSecciones) {
		this.cantidadSecciones = cantidadSecciones;
	}
	
}	