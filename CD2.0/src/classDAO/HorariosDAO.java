package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mantenimientos.Dias;
import utils.MySQLConexion;

public class HorariosDAO {

	public static void buscarCitaDisponible(int ocupadosXY[][],int id_medico,int max[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			
			String sql = "SELECT * FROM horarios WHERE id_medico="+id_medico;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			int j=0;
			while(rs.next()) {// y se añade al arreglo el bloque en formato de hora y el dia
				if(rs.getString(3).equals("8:00-9:30")) {
					j=1;
				}
				else if(rs.getString(3).equals("9:45-11:15")) {
					j=2;
				}
				else if(rs.getString(3).equals("11:30-13:00")) {
					j=3;
				}
				else if(rs.getString(3).equals("14:30-16:00")) {
					j=4;
				}
				else if(rs.getString(3).equals("16:15-17:45")) {
					j=5;
				}
				else if(rs.getString(3).equals("18:00-19:30")) {
					j=6;
				}
				else if(rs.getString(3).equals("19:45-21:15")) {
					j=7;
				}
				ocupadosXY[0][i]=j;
				ocupadosXY[1][i]=rs.getInt(2);
				i++;
			}
			max[0]=i;
			ps.close();
			rs.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	public static void nuevoHorario(boolean ocupados[][],int id_medico) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		
		
		try {
			
			con = MySQLConexion.getConexion();
			String sql=null;
			String fecha=null;
			int flag=1;
			int i=1;
			int j=1;
			while(i<8) {
				j=1;
				while(j<7) {
					if(ocupados[i][j]==true) {
						fecha=Dias.numeroAFecha(i);
						sql = "INSERT INTO horarios values (null,?, ?, ?)";
						pst = con.prepareStatement(sql);
						pst.setInt(1, j);
						pst.setString(2, fecha);
						pst.setInt(3, id_medico);
						pst.executeUpdate();
						flag=0;
					}
					j++;
				}
				i++;
			}
			

			if(flag==0) {
				pst.close();
			}
			
			con.close();
			
			
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en HorarioRandom");
			System.err.println(ex.toString());
		}
	}
	public static void borrarHorarioDeMedico(int id_medico) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		
		
		try {
			int i=1;
			int flag=0;
			con = MySQLConexion.getConexion();
			String sql;
			sql = "DELETE FROM horarios WHERE id_medico="+id_medico;
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
			
			pst.close();
			con.close();
			
			
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en Horario_database.borrarHorarioDeMedico");
			System.err.println(ex.toString());
		}
	}
	public static void insertarHorasRandom(String horarios[],int id_medico,int dia,int max) {
		if(max!=0) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			MySQLConexion conn = new MySQLConexion();
			
			
			try {
				int i=1;
				int flag=0;
				con = MySQLConexion.getConexion();
				String sql;
				
				while(i<=max) {
					
					if(!horarios[i].equals("nada")) {
						flag=1;
						sql = "INSERT INTO horarios values (null,?, ?, ?)";
						pst = con.prepareStatement(sql);
						pst.setInt(1, dia);
						pst.setString(2, horarios[i]);
						pst.setInt(3, id_medico);
						pst.executeUpdate();
					}
					
					i++;
				}
				
				
				if(flag==1) {
					pst.close();
				}
				
				con.close();
				
				
				
				
			}catch(SQLException ex) {
				System.out.println("\nerror en HorarioRandom");
				System.err.println(ex.toString());
			}
		}
		
	}
}
