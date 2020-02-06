package classVO;

public class Usuario {

	private String usuario;
	private String clave;
	private String nombre;
	private String apellidos;
	private String ciudad;
	private String esMedico;
	private int especialidad=-1;
	private String rut;
	
	public Usuario(String usuario, String clave, String nombre, String apellidos, String ciudad, String esMedico,String rut) {

		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.esMedico = esMedico;
		this.rut=rut;
	}
	
	public Usuario(String usuario, String clave, String nombre, String apellidos, String ciudad, String esMedico,int especialidad,String rut) {

		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.esMedico = esMedico;
		this.especialidad=especialidad;
		this.rut=rut;
	}

	public Usuario() {

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getesMedico() {
		return esMedico;
	}
	
	public void setesMedico(String esMedico) {
		this.esMedico = esMedico;
	}
	public int getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(int especialidad) {
		this.especialidad = especialidad;
	}
	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

}
