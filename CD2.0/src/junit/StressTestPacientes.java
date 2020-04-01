package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classDAO.PacientesDAO;
import classVO.PacientesVO;

class StressTestPacientes {

	@Test
	void test() {
		int i=0;
		PacientesVO pacienteTest = new PacientesVO();
		pacienteTest.setApellidos("prueba apellido");
		pacienteTest.setDireccion("prueba direccion");
		pacienteTest.setFecha_nacimiento("prueba fecha");
		pacienteTest.setIdPaciente(null);
		pacienteTest.setNombre("prueba nombre");
		pacienteTest.setRut("prueba rut");
		pacienteTest.setTelefono("telefono");
		
		
		while(i<195382) {//195382
			System.out.println(PacientesDAO.registrarPacientes(pacienteTest));
			i++;
		}
		//PacientesDAO.eliminarPacientesTelefono(pacienteTest.getTelefono());
	}

}
