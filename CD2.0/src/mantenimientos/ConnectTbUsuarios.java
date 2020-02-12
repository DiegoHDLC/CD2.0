package mantenimientos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import classVO.Usuario;
import utils.MySQLConexion;

public class ConnectTbUsuarios {
	

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
