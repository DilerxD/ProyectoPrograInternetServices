package services.beans;

public class Profesor {
	private int id;
	private String nombres;
	private String apellido_paterno;
	private String apellido_materno;
	private String dni;
	private String foto_url;
	private int id_estudio;
	public Profesor() {
		super();
	}
	public Profesor(int id, String nombres, String apellido_paterno, String apellido_materno, String dni,
			String foto_url, int id_estudio) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.id_estudio = id_estudio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombre) {
		this.nombres = nombre;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFoto_url() {
		return foto_url;
	}
	public void setFoto_url(String foto_url) {
		this.foto_url = foto_url;
	}
	public int getId_estudio() {
		return id_estudio;
	}
	public void setId_estudio(int id_estudio) {
		this.id_estudio = id_estudio;
	}
	
	
}
