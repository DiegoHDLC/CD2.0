package classVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Connection;

import utils.MySQLConexion;

public class MedicosVO {
	private Integer idMedico;
	private String nombre;
	private String apellidos;
	private String rut;
	private String especialidad;
	
	public Integer getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return nombre;	
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public Vector<MedicosVO> mostrarMedicos(Integer idEspecialidad){
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = (Connection) MySQLConexion.getConexion();
		
		Vector<MedicosVO> datos = new Vector<MedicosVO>();
		MedicosVO dat = null;
		
		try {
			String sql = "SELECT * FROM medicos WHERE id_especialidad="+idEspecialidad;
			ps = con.clientPrepareStatement(sql);
			rs = ps.executeQuery();
			
			dat = new MedicosVO();
			dat.setIdMedico(0);
			dat.setNombre("Selecciona medico");
			datos.add(dat);
			
			while(rs.next()) {
				dat = new MedicosVO();
				dat.setIdMedico(rs.getInt("id_medico"));
				dat.setNombre(rs.getString("nombre"));
				dat.setApellidos(rs.getString("apellido"));
				dat.setRut(rs.getString("rut"));
				dat.setEspecialidad(rs.getString("especialidad"));
			}
			rs.close();
			
		}catch(SQLException ex) {
			System.err.println(ex.toString());
		}
		return datos;
		
	}

}
