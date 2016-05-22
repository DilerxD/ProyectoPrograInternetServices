package services.requestrespondes;

public class SeccionResponse {
	private int id;
	private int codigo;
	private int id_curso;
	private int id_profesor;
	private String curso;
	private String escuela;
	private int cantidadAlumnos;
	public SeccionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeccionResponse(int id, int codigo, int id_curso, int id_profesor, String curso, String escuela,
			int cantidadAlumnos) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.id_curso = id_curso;
		this.id_profesor = id_profesor;
		this.curso = curso;
		this.escuela = escuela;
		this.cantidadAlumnos = cantidadAlumnos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public int getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	
	
	
	
}
