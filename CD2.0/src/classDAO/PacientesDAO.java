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
	
	public static String registrarPacienteActionPerformed(String txtNombre,String txtApellidos,String txtFecha,String txtRut,String txtTelefono,String txtDireccion) {//GEN-FIRST:event_registrarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        
        
        if(txtNombre.isEmpty() || txtApellidos.isEmpty() || txtFecha.isEmpty()
        		|| txtRut.isEmpty() || txtTelefono.isEmpty() || txtDireccion.isEmpty())	
        	
        {	
        	return "Complete todos los datos para registrar al paciente";
        }
        else {
        	if(!PacientesDAO.repiteRut(txtRut)) {
        		 pac.setNombre(txtNombre);
        	     pac.setApellidos(txtApellidos);
        	     pac.setFecha_nacimiento(txtFecha);
        	     pac.setRut(txtRut);
        	     pac.setDireccion(txtDireccion);
        	     pac.setTelefono(txtTelefono);
        	     String resp = PacientesDAO.registrarPacientes(pac);
        	     return resp;
        	}else {return "El rut ya esta ocupado";}
        }
    }//GEN-LAST:event_registrarProveedorActionPerformed

	public static String actualizarPacienteActionPerformed(String txtNombre,String txtApellidos,String txtFecha,String txtRut,String txtTelefono,String txtDireccion) {//GEN-FIRST:event_actualizarProveedorActionPerformed
        PacientesVO pac = new PacientesVO();
        pac.setIdPaciente(PacientesDAO.getId(txtRut));
        pac.setNombre(txtNombre);
        pac.setApellidos(txtApellidos);
        pac.setFecha_nacimiento(txtFecha);
        pac.setRut(txtRut);
        pac.setDireccion(txtDireccion);
        pac.setTelefono(txtTelefono);
        String resp = PacientesDAO.ActualizarPacientes(pac);
        return resp;
    }//GEN-LAST:event_actualizarProveedorActionPerformed
	
	public static PacientesVO buscarPacienteActionPerformed(String txtNombre,String txtApellidos,String txtFecha,String txtRut,String txtTelefono,String txtDireccion) {//GEN-FIRST:event_buscarProveedorActionPerformed
			
			if(txtRut.isEmpty()) {
				return null;
			}else {
			
			PacientesVO pac = PacientesDAO.buscarPacientes(txtRut);
	    
	        return pac;
			}
	    }
	
	public static String eliminarPacienteActionPerformed(String txtNombre,String txtApellidos,String txtFecha,String txtRut,String txtTelefono,String txtDireccion) {
		if(txtNombre.isEmpty() || txtApellidos.isEmpty() || txtFecha.isEmpty()
        		|| txtRut.isEmpty() || txtTelefono.isEmpty() || txtDireccion.isEmpty()) 
        {
        	return "Complete todos los datos para eliminar al paciente";
        }
        else {
        String resp = PacientesDAO.eliminarPacientes(txtRut);
        return resp;
        }
    }
	
	
	
	public static boolean repiteRut(String rut) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			
			String sql = "SELECT * FROM pacientes where rut='"+rut+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return true;
			}
		
			con.close();
			rs.close();
			return false;
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en PacientesDatabase");
			System.err.println(ex.toString());
			
		}
		
		return false;
	}
	public static int obtenerPacientes() {
		int pacientes=1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			
			String sql = "SELECT * FROM pacientes";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pacientes++;
			}
		
			con.close();
			rs.close();
			return pacientes;
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en PacientesDatabase.wolfram");
			System.err.println(ex.toString());
			return pacientes;
		}
		
	}
	public static boolean obtenerDatosConRut(String datos[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			System.out.println("rut a buscar: "+datos[3]);
			String sql = "SELECT * FROM pacientes WHERE rut="+"'"+datos[3]+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int flag=0;
			while(rs.next()) {
				flag=1;
				datos[0]=rs.getString(2);
				datos[1]=rs.getString(3);
				datos[2]=rs.getString(4);
				datos[3]=rs.getString(5);
				datos[4]=rs.getString(6);
				datos[5]=rs.getString(7);
				
	
				
				
			}
		
			con.close();
			rs.close();
			if(flag==1) {
				return true;
			}
			else {
				return false;
			}
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en pacientes database.obtenerDatosConRut");
			System.err.println(ex.toString());
			return false;
		}
	}
	public static String registrarPacientes2(PacientesVO pac,Connection cn) {
		String result = null, last = null;
		
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
		}
		return result;
	}
	public static void eliminarPacientesTelefono(String telefono) {
		
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
        PreparedStatement pst = null;
        String sql = "DELETE FROM pacientes where telefono='telefono' ";
		try {
			pst = cn.prepareStatement(sql);
			pst.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(cn != null) {
					cn.close();
					pst.close();
				}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}
		
	}
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
	
	public static int getId(String rut) {
		int id=-1;
		
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
		PreparedStatement pst = null;
		String sql = "SELECT * FROM pacientes WHERE rut = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, rut);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
					return rs.getInt(1);	
			}
			else {
				
				return id;
				
			}
			
		}catch(SQLException e) {
			System.out.println(e.toString());
			return id;
		}
		
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