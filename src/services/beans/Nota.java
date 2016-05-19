package services.beans;

public class Nota {
	private int id;
	private int id_alumno_seccion;
	private int nota;
	public Nota() {
		super();
		
	}
	public Nota(int id, int id_alumno_seccion, int nota) {
		super();
		this.id = id;
		this.id_alumno_seccion = id_alumno_seccion;
		this.nota = nota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_alumno_seccion() {
		return id_alumno_seccion;
	}
	public void setId_alumno_seccion(int id_alumno_seccion) {
		this.id_alumno_seccion = id_alumno_seccion;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	
}
