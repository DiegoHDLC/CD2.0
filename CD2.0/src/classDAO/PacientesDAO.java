package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classVO.PacientesVO;
import main.Secre;
import utils.MySQLConexion;

public class PacientesDAO {
	@SuppressWarnings("resource")
	public static String registrarPacientes(PacientesVO pac) {
		String result = null, last = null;
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
        PreparedStatement pst = null;
		String sql = "INSERT INTO pacientes values (null,?,?,?,?,?,?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1,pac.getNombre());
			pst.setString(2,pac.getApellidos());
			pst.setString(3,pac.getFecha_nacimiento());
			pst.setString(4,pac.getRut());
			pst.setString(5,pac.getDireccion());
			pst.setString(6,pac.getTelefono());
			pst.execute();
			pst = cn.prepareStatement("SELECT MAX(id_paciente) AS id FROM pacientes");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				last = rs.getString(1);
			}
			result = "Paciente registrado con exito, ID:"+last;
		}catch(SQLException e) {
			result = "Error en la consulta: "+e.getMessage();
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					result = "Error: "+e;
				}
		}
		return result;
	}
	public static String ActualizarPacientes(PacientesVO pac) {
		String result = null;
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
		PreparedStatement pst = null;
		String sql = "UPDATE pacientes SET nombre=?,apellidos=?,fecha_nacimiento=?,rut=?,direccion=?,telefono=? WHERE id_paciente=?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1,pac.getNombre());
			pst.setString(2,pac.getApellidos());
			pst.setString(3,pac.getFecha_nacimiento());
			pst.setString(4,pac.getRut());
			pst.setString(5,pac.getDireccion());
			pst.setString(6,pac.getTelefono());
			pst.setInt(7,pac.getIdPaciente());
			pst.execute();
			result = "Paciente actualizado con exito, RUT:"+pac.getRut();
		}catch(SQLException e) {
			result = "Error en la consulta: "+e.getMessage();
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					result = "Error: "+e;
				}
		}
		return result;
	}
	
	public static PacientesVO buscarPacientes(String rut) {
		PacientesVO pac = new PacientesVO();
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
		PreparedStatement pst = null;
		//String sql = "SELECT * FROM pacientes WHERE id_paciente = ?";
		String sql = "SELECT * FROM pacientes WHERE rut = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, rut);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				
					pac.setIdPaciente(Integer.parseInt(rs.getString(1)));
					pac.setNombre(rs.getString(2));
					pac.setApellidos(rs.getString(3));
					pac.setFecha_nacimiento(rs.getString(4));
					pac.setRut(rs.getString(5));
					pac.setDireccion(rs.getString(6));
					pac.setTelefono(rs.getString(7));
					pac.setResultado("Busqueda Exitosa");
					

			}
			else {
				//pac.setResultado(""+pac.getRut());
				pac.setResultado("Paciente no encontrado");
			}
			
		}catch(SQLException e) {
			pac.setResultado("Error en la consulta: "+e.getMessage());
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					pac.setResultado("Error: "+e);
				}
		}
		return pac;
	}
	public static String eliminarPacientes(String clave) {
		String result = null;
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
		PreparedStatement pst = null;
		String sql = "DELETE FROM pacientes WHERE rut = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1,clave);
			pst.executeUpdate();
			result = "Paciente eliminado con éxito";
			
		}catch(SQLException e) {
			result = "Error en la consulta: "+e.getMessage();
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					result = "Error: "+e;
				}
		}
		return result;
	}
	
	public static ArrayList<PacientesVO> getListPacientes(){
		ArrayList<PacientesVO> arrPac = new ArrayList<PacientesVO> ();
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
		PreparedStatement pst = null;
		PacientesVO pac = null;
		String sql = "SELECT * FROM pacientes";
		try {
			pst = cn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				pac = new PacientesVO();
				pac.setIdPaciente(Integer.parseInt(rs.getString(1)));
				pac.setNombre(rs.getString(2));
				if(arrPac.isEmpty()) {
					arrPac.add(0,pac);
				}else {
					arrPac.add(pac);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error en la consulta: "+e.getMessage());
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					System.out.println("Error: "+e);
				}
		}
		return arrPac;
	}
}	