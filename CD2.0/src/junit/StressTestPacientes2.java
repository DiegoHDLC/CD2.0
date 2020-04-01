package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import classDAO.PacientesDAO;
import classVO.PacientesVO;
import utils.MySQLConexion;

class StressTestPacientes2 {

	@Test
	void test() {
		int i=0;
		//empezamos con 8,71 gb
		PacientesVO pacienteTest = new PacientesVO();
		pacienteTest.setApellidos("prueba apellido");
		pacienteTest.setDireccion("prueba direccion");
		pacienteTest.setFecha_nacimiento("prueba fecha");
		pacienteTest.setIdPaciente(null);
		pacienteTest.setNombre("prueba nombre");
		pacienteTest.setRut("prueba rut");
		pacienteTest.setTelefono("telefono");
		
		MySQLConexion cc = new MySQLConexion();
		Connection cn = cc.getConexion();
		
		while(i<195382) {//195382
			PacientesDAO.eliminarPacientesTelefono(pacienteTest.getTelefono());
		 //System.out.println(PacientesDAO.registrarPacientes2(pacienteTest,cn));
			i++;
		}
		
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// terminamos con 8,60 gb
		PacientesDAO.eliminarPacientesTelefono(pacienteTest.getTelefono());
	}

}
