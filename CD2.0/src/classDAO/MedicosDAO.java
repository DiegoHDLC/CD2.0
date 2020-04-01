package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classVO.Usuario;

import utils.MySQLConexion;

public class MedicosDAO {
	
	public static void registrarEnTablaMedico(Usuario usu) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			
			con = MySQLConexion.getConexion();
				String sql = "INSERT INTO medicos values (null,?, ?, ?, ?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, usu.getNombre());
				pst.setString(2, usu.getApellidos());
				pst.setString(3, usu.getRut());
				pst.setInt(4, usu.getEspecialidad());
				pst.executeUpdate();
			
			pst.close();
			con.close();	
			
			} 
			catch (Exception e) {
				System.out.println("Error en 'medico_database.registrarEnTablaMedico'");
				System.err.println(e.toString());
			}
		
	}
	
	public static int contarEspecialidades(int id_especialidad) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		
		try {
		
			String sql = "SELECT * FROM medicos WHERE id_especialidad="+id_especialidad;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int repeticiones=0;
			while(rs.next()) {
			
				repeticiones= repeticiones+CitasDAO.repeticionesMedico(rs.getInt(1));
				
			}
			
			con.close();
			rs.close();
			
			return repeticiones;
			
		}catch(SQLException ex) {
			System.out.println("\nerror en medico database.contarEspecialidades");
			System.err.println(ex.toString());
			return 0;
		}
	}
	
	public static int getId_medico(String rut) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		int id_medico=0;
		try {
			System.out.println("Rut get id medico: "+rut);
			String sql = "SELECT * FROM medicos WHERE rut="+"'"+rut+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				
			while(rs.next()) {
				
				id_medico=rs.getInt(1);	
				con.close();
				rs.close();
				return id_medico;
			}
			
			con.close();
			rs.close();
			
			return id_medico;
			
		}catch(SQLException ex) {
			System.out.println("\nerror en medico database.getIdMedico");
			System.err.println(ex.toString());
			return 0;
		}
	}
	public int getUltimoId_medico() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int id_medico=0;
		try {
			
			String sql = "SELECT * FROM medicos";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				
			while(rs.next()) {
				id_medico=rs.getInt(1);			
			}
			
			con.close();
			rs.close();
			
			return id_medico;
			
		}catch(SQLException ex) {
			System.out.println("\nerror en medico database.getUltimoId_medico");
			System.err.println("medico database.getultimoid_medico"+ex.toString());
			return 0;
		}
	}
}
