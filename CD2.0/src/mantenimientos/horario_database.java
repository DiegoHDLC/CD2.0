package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class horario_database {
	public horario_database() {
		
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
					System.out.println("maximo es "+max+" horario:"+horarios[i]);
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
