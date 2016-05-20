package services.requestrespondes;

public class AlumnoResponse {
	private int id;
	private String nombres;
	private String apellido_paterno;
	private String apellido_materno;
	private String dni;
	private String foto_url;
	private int codigo;
	private String colegio;
	public AlumnoResponse(int id, String nombres, String apellido_paterno, String apellido_materno, String dni,
			String foto_url, int codigo, String colegio) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.dni = dni;
		this.foto_url = foto_url;
		this.codigo = codigo;
		this.colegio = colegio;
	}
	
	public AlumnoResponse() {
		super();
		// TODO Auto-generated constructor stub
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
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getColegio() {
		return colegio;
	}
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}
	
	
}
