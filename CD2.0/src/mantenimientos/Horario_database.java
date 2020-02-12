package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class Horario_database {
	public Horario_database() {
		
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
