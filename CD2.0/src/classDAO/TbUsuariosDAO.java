package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classVO.Usuario;
import utils.MySQLConexion;

public class TbUsuariosDAO {
	public static Usuario obtenerUsuario(Usuario usu){
		
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		
			con = MySQLConexion.getConexion();
		
			String sql = "select*from tb_usuario where usuario = ? and clave =  ? ";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				usuario = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8));
				
			}
			
		} catch (Exception e) {
		System.out.println("Error en obtener usuario");
		}
		
		
		return usuario;
		
	}
	
	public static int repiteUsuario(String usuario1) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();

		try {
			
			String sql = "SELECT * FROM tb_usuario WHERE usuario="+"'"+usuario1+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("\nMostrando datos:\n");		
			while(rs.next()) {
				System.out.println("base "+rs.getString(1)+" usuario1  "+usuario1);				
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(usuario1)) {
					System.out.println("\nhay repetido\n");
					rs.close();
					con.close();
					return 1;
				}
				
			}
			System.out.println("no hay repetido");
			con.close();
			rs.close();
			
			return 0;
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
			return 0;
		}
	}
	public static boolean repiteRut(String rut) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection con = MySQLConexion.getConexion();
		
		try {
			
			String sql = "SELECT * FROM tb_usuario where rut='"+rut+"'";
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
	public static String getRut(String usuario,String clave) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection con = MySQLConexion.getConexion();
		String rut;
		try {
			
			String sql = "SELECT * FROM tb_usuario WHERE usuario='"+usuario+"' AND clave='"+clave+"'";
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
			
			String sql = "SELECT * FROM tb_usuario WHERE usuario='"+usuario+"' AND clave='"+clave+"' AND medico=1";
			
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

	public static void insertUsuario(Usuario usu) {
	Connection con = null;
	PreparedStatement pst = null;
	try {
		
		con = MySQLConexion.getConexion();
			String sql = "INSERT INTO tb_usuario values (?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getClave());
			pst.setString(3, usu.getNombre());
			pst.setString(4, usu.getApellidos());
			pst.setString(5, usu.getCiudad());
			pst.setInt(6, Integer.parseInt(usu.getesMedico()));
			pst.setInt(7, usu.getEspecialidad());
			pst.setString(8,usu.getRut());
			pst.executeUpdate();
			pst.close();
		con.close();
		
		
		
		} 
		catch (Exception e) {
			System.out.println("Error en obtener usuario 'connect_tbUsuarios'");
			System.err.println(e.toString());
		}
	
	}
}
