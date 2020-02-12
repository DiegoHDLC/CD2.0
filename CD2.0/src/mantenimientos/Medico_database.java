package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class Medico_database {
	public Medico_database() {
		
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
	public static void main(String[] args) {//prueba
		Medico_database med = new Medico_database();
		System.out.println(med.getUltimoId_medico());
	}

}
