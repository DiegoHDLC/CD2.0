package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import classDAO.CitasDAO;
import classVO.CitasVO;
import utils.MySQLConexion;

class StressTestCitas {
	//	cuc 12 dent concepcion
	// beladent 10 santiago
	// 10 cerro grande la serena
	// testeando 72*7*6=3548
	@Test
	void test() {
		CitasVO cita = new CitasVO(
				8,24,12,"prueba rut",1,117,"prueba diagnostico"
				);
		MySQLConexion cc = new MySQLConexion();
     
		Connection cn = cc.getConexion();
		int i=0;
		while(i<500) {
			cita.setRut("prueba rut"+Integer.toString(i));
			CitasDAO.insertarDatos2(cn,cita);
			System.out.println(i);
			i++;
		}
		//FechasOcupadas_database.eliminarTestCita(cn);
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// 12*7*6=504
	
}
