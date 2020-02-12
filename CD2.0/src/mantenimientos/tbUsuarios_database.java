package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class tbUsuarios_database {
	private String rut;
	private String usuario;
	private String clave;
	public tbUsuarios_database() {
		
	}
	public static String getRut(String usuario,String clave) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		String rut;
		try {
			
			String sql = "SELECT * FROM tb_usuario WHERE usuario="+usuario+" AND clave="+clave;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				
			while(rs.next()) {
				rut=rs.getString(8);	
				con.close();
				rs.close();
				return rut;
			}
			
			con.close();
			rs.close();
			
			return null;
			
		}catch(SQLException ex) {
			System.out.println("\nerror en medico database.getIdMedico");
			System.err.println(ex.toString());
			return null;
		}
	}
	public static boolean esMedico(String usuario,String clave) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		try {
			
			String sql = "SELECT * FROM tb_usuario WHERE usuario="+usuario+" AND clave="+clave+" AND medico=1";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
				
			while(rs.next()) {
				con.close();
				rs.close();
				return true;			
			}
			con.close();
			rs.close();
			return false;
			
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en tbUsuarios_database.esMedico");
			System.err.println("error tbUsuarios_database.esMedico" +ex.toString());
			return false;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
