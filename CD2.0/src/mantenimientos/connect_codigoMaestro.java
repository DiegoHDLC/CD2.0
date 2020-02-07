package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import classVO.Usuario;
import utils.MySQLConexion;

public class connect_codigoMaestro{
	
	public static String getCodigoMaestro() {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String codigo = null;
	
	try {
	
		con = MySQLConexion.getConexion();
	
		String sql = "select*from codigo_maestro";
		
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		rs.next();
		System.out.println("\n"+rs.getString(1));
		codigo = rs.getString(1);
		con.close();
		return codigo;
		
		
		} 
		catch (Exception e) {
			System.out.println("Error en obtener codigo maestro");
			return null;
		}
	}
}
