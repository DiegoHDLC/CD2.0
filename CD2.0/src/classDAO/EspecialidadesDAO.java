package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class EspecialidadesDAO {
	public static String[] comboEspecialidades() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		try {
			
			
			String sql = "SELECT * FROM especialidades_medicas";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			int i=1;
			while(rs.next()) {
				i++;
			}
			
			
			sql = "SELECT * FROM especialidades_medicas";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			String[] comboEsp = new String[i];
			comboEsp[0]="Seleccione especialidad";
			i=1;
			
			while(rs.next()) {
				comboEsp[i]=rs.getString("especialidad");
				i++;
			}
			rs.close();
			return comboEsp;
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
			return null;
		}
	}
	
	public static String getEspecialidad(int id) {
		String especialidad;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int i=0;
		try {
			
			
			String sql = "SELECT * FROM especialidades_medicas where id_especialidad="+id;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getString(2);
			}
		
			con.close();
			rs.close();
			return null;
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en especialidades_database.especialidadesDatabase");
			System.err.println(ex.toString());
			return null;
		}
	}
	public static void rellenarEspecialidades(int transformar[][]) {
		int especialidades=1;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int i=0;
		try {
			
			String sql = "SELECT * FROM especialidades_medicas";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				transformar[i][0]=rs.getInt(1);
				transformar[i][1]=i+1;
				i++;
			}
		
			con.close();
			rs.close();
			
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en especialidades_database.rellenarEspecialidades");
			System.err.println(ex.toString());
			
		}
	}
	public static int obtenerEspecialidades() {
		int especialidades=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			
			String sql = "SELECT * FROM especialidades_medicas";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				especialidades++;
			}
		
			con.close();
			rs.close();
			return especialidades;
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en especialidades_database.obtenerEspecialidades");
			System.err.println(ex.toString());
			return especialidades;
		}
		
	}
}
