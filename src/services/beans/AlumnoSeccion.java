package services.beans;

public class AlumnoSeccion {
	
	
	private int id;
	private int id_alumno;
	private int id_seccion;
	private int codigo;
	private String apellido_paterno;
	private String apellido_materno;
	private String nombre;
	public AlumnoSeccion(int id, int id_alumno, int id_seccion, int codigo, String apellido_paterno,
			String apellido_materno, String nombre) {
		super();
		this.id = id;
		this.id_alumno = id_alumno;
		this.id_seccion = id_seccion;
		this.codigo = codigo;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.nombre = nombre;
	}
	public AlumnoSeccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public int getId_seccion() {
		return id_seccion;
	}
	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getApellido_paterno() {
		return apellido_paterno;
	}
	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	public String getApellido_materno() {
		return apellido_materno;
	}
	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
