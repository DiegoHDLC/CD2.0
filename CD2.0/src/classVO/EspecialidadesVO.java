package classVO;

public class EspecialidadesVO extends MedicosVO {
	private int id;
	private String especialidad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String toString() {
		return this.especialidad;
	}
	
}
