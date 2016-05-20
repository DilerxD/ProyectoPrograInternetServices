package services.beans;

public class Seccion {

	
	private int id;
	private int codigo;
	private int id_curso;
	private int id_profesor;
	public Seccion() {
		super();
	}
	public Seccion(int id, int codigo, int id_curso, int id_profesor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.id_curso = id_curso;
		this.id_profesor = id_profesor;
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
	
	

}
