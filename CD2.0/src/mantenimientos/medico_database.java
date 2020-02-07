package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class medico_database {
	public medico_database() {
		
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
			System.out.println("\nerror en medico database");
			System.err.println(ex.toString());
			return 0;
		}
	}
	public static void main(String[] args) {//prueba
		medico_database med = new medico_database();
		System.out.println(med.getUltimoId_medico());
	}

}
