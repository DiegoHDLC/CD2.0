package classVO;

public class CitasVO {
	private int id_medico;
	private int dia;
	private int mes_fecha;
	private int bloque;
	private int dia_fecha;
	private String rut;
	private String diagnostico;
	public CitasVO(int bloque,int dia_fecha,int mes_fecha) {
		this.setBloque(bloque);
		this.setDia_fecha(dia_fecha);
		this.setMes_fecha(mes_fecha);
	}
	public CitasVO(int bloque,int dia_fecha,int mes_fecha,String rut,int dia,int id_medico,String diagnostico) {
		this.setBloque(bloque);
		this.setDia_fecha(dia_fecha);
		this.setMes_fecha(mes_fecha);
		this.setDia(dia);
		this.setRut(rut);
		this.setId_medico(id_medico);
		this.setDiagnostico(diagnostico);
	}
	
	public int getId_medico() {
		return id_medico;
	}
	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}
	public int getMes_fecha() {
		return mes_fecha;
	}
	public void setMes_fecha(int mes_fecha) {
		this.mes_fecha = mes_fecha;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getBloque() {
		return bloque;
	}
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	public int getDia_fecha() {
		return dia_fecha;
	}
	public void setDia_fecha(int dia_fecha) {
		this.dia_fecha = dia_fecha;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
}
