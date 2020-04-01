package classDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classVO.CitasVO;
import mantenimientos.Dias;
import utils.MySQLConexion;

public class CitasDAO {
	
	
	public static void guardarFechasOcupadas(Object fechas[],int idMedicos[],int index) {
		int i=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			String sql = "SELECT * FROM fechas_ocupadas WHERE id_medico="+idMedicos[index];
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				fechas[i]="Fecha: "+rs.getInt(6)+"/"+rs.getInt(4)+"    Rut: "+rs.getString(7)+"   "+Dias.numeroAFecha(rs.getInt(5));
				i++;
			}
			ps.close();
			rs.close();
			
		}catch(SQLException ex) {
			System.out.println("error en Secre.guardarFechasOcupadas");
			System.err.println(ex.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static String[] filtrarMedico(int idMedicos[],String comboEsp) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		int nEspecialidad=-1;
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			
			String sql = "SELECT * FROM especialidades_medicas WHERE especialidad="+"'"+comboEsp+"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nEspecialidad=rs.getInt(1);
				
			}
			
			
			
			//conteo
			
			sql = "SELECT * FROM medicos WHERE id_especialidad="+nEspecialidad;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()) {// y los añado al combo box
				i++;
			}
			
			
			//luego en la tabla medico busco todos los medicos que tengan el numerito de la especialidad
			sql = "SELECT * FROM medicos WHERE id_especialidad="+nEspecialidad;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			String[] comboMedico= new String[i];
			i=0;
			while(rs.next()) {// y los añado al combo box
				
				idMedicos[i]=rs.getInt(1);
				comboMedico[i]=rs.getString(2)+" "+rs.getString(3);
				i++;
			}
			rs.close();
			return comboMedico;
			
		}catch(SQLException ex) {
			System.out.println("error e fechasOcupadasDatabase.filtrarMedico");
			System.err.println(ex.toString());
			return null;
		}
		
	}
	
	public static int repeticionesMedico(int id) {
		int contador=0;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
	
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			String sql = "SELECT * FROM fechas_ocupadas WHERE id_medico="+id;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				contador++;
			}
			ps.close();
			rs.close();
			con.close();
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
		
		
		return contador;
	}
	public static void guardarCitas(Object fechas[],int idMedico) {
		int i=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = MySQLConexion.getConexion();
		String hora;
		String dia;
		
		
		try {
			//busco en la tabla especialidad el numerito correspondiente a mi especialidad en formato string
			String sql = "SELECT * FROM fechas_ocupadas WHERE id_medico="+idMedico;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hora=Dias.numeroAFecha(rs.getInt(5));
				dia=Dias.numeroADia(rs.getInt(3));
				
				fechas[i]="Fecha: "+dia+" "+rs.getInt(6)+"/"+rs.getInt(4)+"    Rut: "+rs.getString(7)+"    Hora: "+hora;
				i++;
			}
			ps.close();
			rs.close();
			con.close();
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
	}
	public static void eliminarTestCita(Connection con) {
		try {
			String query = "delete from fechas_ocupadas where diagnostico = 'prueba diagnostico'";
		      PreparedStatement preparedStmt = ((Connection) con).prepareStatement(query);
		      preparedStmt.executeUpdate();
		      preparedStmt.close();		
		}catch(SQLException ex) {
			System.err.println(ex.toString());
		}
	}
	public static void eliminarCita(int id_medico,String dia_fecha,String mes_fecha,int bloque) {

		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		System.out.println("id medico="+id_medico+" dia_fecha="+dia_fecha+" mes_fecha="+mes_fecha+" bloque="+bloque);
		try {
			String query = "delete from fechas_ocupadas where bloque = ? and dia_fecha= ? and mes_fecha= ? and id_medico= ?";
		      PreparedStatement preparedStmt = ((Connection) con).prepareStatement(query);
		     
		      preparedStmt.setInt(1, bloque);
		      preparedStmt.setString(2, dia_fecha);
		      preparedStmt.setString(3, mes_fecha);
		      preparedStmt.setInt(4, id_medico);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      
		      
			
			
		      preparedStmt.close();
		      con.close();
			
		
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		
		}
	}
	public static void setDiagnostico(int id_medico,String dia_fecha,String mes_fecha,int bloque,String diagnostico) {
		
		
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		
		try {
			String query = "update fechas_ocupadas set diagnostico = ? where bloque = ? and dia_fecha= ? and mes_fecha= ? and id_medico= ?";
		      PreparedStatement preparedStmt = ((Connection) con).prepareStatement(query);
		      preparedStmt.setString   (1,diagnostico);
		      preparedStmt.setInt(2, bloque);
		      preparedStmt.setString(3, dia_fecha);
		      preparedStmt.setString(4, mes_fecha);
		      preparedStmt.setInt(5, id_medico);
		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      
		      
			
			
		      preparedStmt.close();
		      con.close();
			
		
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		
		}
	}
	public static String getDiagnostico(int id_medico,int dia_fecha,int mes_fecha,int bloque) {
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		String diagnostico=null;
		
		try {
			int flag=0;
			String sql = "SELECT * FROM fechas_ocupadas WHERE bloque="+bloque+" "
					+ "AND dia_fecha="+dia_fecha
					+" AND mes_fecha="+mes_fecha
					+ " AND id_medico="+id_medico;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				diagnostico=rs.getString(8);
				ps.close();
				rs.close();
				return diagnostico;
				
			}
			ps.close();
			rs.close();
			con.close();
			return diagnostico;
		
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
			return null;
		}
		
	}
	public static void insertarDatos2(Connection cn,CitasVO cita) {
		 
		try {
			
			PreparedStatement pst = null;
			String sql = "INSERT INTO fechas_ocupadas values (null,?,?,?,?,?,?,?)";
			pst = cn.prepareStatement(sql);
			pst.setInt(1,cita.getId_medico());
			pst.setInt(2,cita.getDia());
			pst.setInt(3,cita.getMes_fecha());
			pst.setInt(4,cita.getBloque());
			pst.setInt(5,cita.getDia_fecha());
			pst.setString(6,cita.getRut());
			pst.setString(7, cita.getDiagnostico());
			pst.execute();
			
			pst.close();
			
		}catch(SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error en fechasOcupadas_database.insertarDatos ");
		}
	}
	public static void insertarDatos(CitasVO cita) {
		String result = null, last = null;
		MySQLConexion cc = new MySQLConexion();
        @SuppressWarnings("static-access")
		Connection cn = cc.getConexion();
        
		try {
			
			PreparedStatement pst = null;
			String sql = "INSERT INTO fechas_ocupadas values (null,?,?,?,?,?,?,?)";
			pst = cn.prepareStatement(sql);
			pst.setInt(1,cita.getId_medico());
			pst.setInt(2,cita.getDia());
			pst.setInt(3,cita.getMes_fecha());
			pst.setInt(4,cita.getBloque());
			pst.setInt(5,cita.getDia_fecha());
			pst.setString(6,cita.getRut());
			pst.setString(7, cita.getDiagnostico());
			pst.execute();
			cn.close();
			pst.close();
			
		}catch(SQLException e) {
			System.err.println(e.toString());
			System.out.println("Error en fechasOcupadas_database.insertarDatos ");
		}
	}
	public static boolean buscarFecha(CitasVO cita) {
		int i=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		
		
		try {
			int flag=0;
			String sql = "SELECT * FROM fechas_ocupadas WHERE bloque="+cita.getBloque()+" AND dia_fecha="+cita.getDia_fecha()+" AND mes_fecha="+cita.getMes_fecha();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {	
				flag=1;
				
			}
			ps.close();
			rs.close();
			if(flag==1) {
				return true;
			}
			else {
				return false;
			}
		
			
		}catch(SQLException ex) {
			
			System.err.println(ex.toString());
		}
		return false;
	}

}
