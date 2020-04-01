package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classDAO.MedicosDAO;
import classDAO.PacientesDAO;
import classDAO.EspecialidadesDAO;
import utils.MySQLConexion;

public class WolframInput {
	
	
	public static void main(String[] args) {
		
		int[] parametro1Aux=new int[EspecialidadesDAO.obtenerEspecialidades()+PacientesDAO.obtenerPacientes()];
		int x=EspecialidadesDAO.obtenerEspecialidades();
		int transformar[][]= new int[x][2];
		String elmaineador=parametro2(parametro1Aux,transformar);
		int max= elmaineador.length();
		
		String elmaineador2=Arrays.replace(elmaineador,max-1,' ');
		String parametro1=Arrays.intToStringWM(parametro1Aux);
		System.out.println("string: "+elmaineador2+"su tamaño:"+max+ "parametro1: "+parametro1);

	}
	public static String parametro2Barchart() {
		int x=EspecialidadesDAO.obtenerEspecialidades();
		int[][] especialidades= new int[x][2];
		EspecialidadesDAO.rellenarEspecialidades(especialidades);
		String param;
		int i=0;
		param=" \""+EspecialidadesDAO.getEspecialidad(especialidades[i][0])+"\" ";
		i++;
		while(i<x) {
			param=param +", \""+EspecialidadesDAO.getEspecialidad(especialidades[i][0])+"\" ";
			i++;
		}
		
		
		return param;
	}
	public static String parametro1Barchart() {
		int x=EspecialidadesDAO.obtenerEspecialidades();
		int[][] especialidades= new int[x][2];
		EspecialidadesDAO.rellenarEspecialidades(especialidades);
		int i=0;
		System.out.println("especialidad a contar:"+EspecialidadesDAO.getEspecialidad(especialidades[i][0]));
		String param=Integer.toString(MedicosDAO.contarEspecialidades(especialidades[i][0]));
		System.out.println("concatenacion: "+param);
		i++;
		while(i<x) {
			System.out.println("especialidad a contar:"+EspecialidadesDAO.getEspecialidad(especialidades[i][0]));
			param = param+","+MedicosDAO.contarEspecialidades(especialidades[i][0]);
			System.out.println("concatenacion: "+param);
			
			i++;
		}
		
		return param;
		
	}
	public static String parametro2(int parametro1[],int transformar[][]){
		
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs3 = null;
		MySQLConexion conn = new MySQLConexion();
		Connection con = MySQLConexion.getConexion();
		int especialidad;
		
		String parametro2="";
		int i=0,j=2;
		int maxEspecialidades=EspecialidadesDAO.obtenerEspecialidades();
		
		
		int pacientes=1;
		EspecialidadesDAO.rellenarEspecialidades(transformar);
		int l=0;
		try {
			
			String sql = "SELECT * FROM pacientes";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(i<maxEspecialidades) {
				parametro1[i]=pacientes;
				System.out.print(parametro1[i]+" ");
				i++;
				pacientes++;
				
			}
			System.out.println("\n"+pacientes+" "+maxEspecialidades);
			while(rs.next()) {//para cada paciente
				
				parametro1[i]=pacientes;
				
				
				sql = "SELECT * FROM fechas_ocupadas WHERE rut='"+rs.getString(5)+"'";//para cada fecha ocupada
																					// con este rut
				ps2 = con.prepareStatement(sql);
				rs2 = ps2.executeQuery();
				while(rs2.next()) {
					
					sql = "SELECT * FROM medicos WHERE id_medico="+rs2.getInt(2);
					ps3 = con.prepareStatement(sql);
					rs3 = ps3.executeQuery();
					
					rs3.next();
					
					especialidad=rs3.getInt(5);// y para cada id medico de ese 
													//rut se busca la especialidad en formato int
					// en resumen para cada cita de un paciente se busca su rut , 
					// con ese rut se busca el id medico y su correspondiente especialidad
					// luego se concatena en formato wolfram
					
					
					l=0;
					while(l<maxEspecialidades) {
						if(transformar[l][0]==especialidad) {
							parametro2=parametro2+Integer.toString(transformar[l][1])+"<->"+Integer.toString(pacientes)+",";
							
							break;
						}
						l++;
					}
					
				}
				
				pacientes++;
				i++;
			}
			
			i=0;
			System.out.println("");
			while(i<parametro1.length) {
				System.out.print(" "+parametro1[i]);
				i++;
			}
			
			
			con.close();
			if(!(rs==null)) {
				rs.close();
			}if(!(rs2==null)) {
				rs2.close();
			}if(!(rs3==null)) {
				rs3.close();
			}if(!(ps==null)) {
				ps.close();
			}if(!(ps2==null)) {
				ps2.close();
			}if(!(ps3==null)) {
				ps3.close();
			}
			
			
			
			
			
			
			
			
			
			return parametro2;
			
			
		}catch(SQLException ex) {
			System.out.println("\nerror en PacientesDatabase.wolfram");
			System.err.println(ex.toString());
			return null;
		}
		
		
	}
	
}
