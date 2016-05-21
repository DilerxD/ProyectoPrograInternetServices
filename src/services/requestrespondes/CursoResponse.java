package services.requestrespondes;

public class CursoResponse {
	private int id;
	private String nombre;
	private int codigo;
	private String escuela;
	private int cantidadSecciones;
	public CursoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoResponse(int id, String nombre, int codigo, String escuela, int cantidadSecciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.escuela = escuela;
		this.cantidadSecciones = cantidadSecciones;
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
