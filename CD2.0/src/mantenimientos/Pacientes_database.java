package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MySQLConexion;

public class Pacientes_database {

	public static boolean obtenerDatosConRut(String datos[]) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		try {
			System.out.println("rut a buscar: "+datos[3]);
			String sql = "SELECT * FROM pacientes WHERE rut="+"'"+datos[3]+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int flag=0;
			while(rs.next()) {
				flag=1;
				datos[0]=rs.getString(2);
				datos[1]=rs.getString(3);
				datos[2]=rs.getString(4);
				datos[3]=rs.getString(5);
				datos[4]=rs.getString(6);
				datos[5]=rs.getString(7);
				
	
				
				
			}
		
			con.close();
			rs.close();
			if(flag==1) {
				return true;
			}
			else {
				return false;
			}
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en medico database.getIdMedico");
			System.err.println(ex.toString());
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
