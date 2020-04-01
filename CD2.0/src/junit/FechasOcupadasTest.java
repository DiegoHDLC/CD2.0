package junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import classDAO.CitasDAO;
import classVO.CitasVO;

class FechasOcupadasTest {

	@Test
	void test() {
		CitasVO cita = new CitasVO(1,12,10,"20.988.762-3",5,12,"Enrojecimiento, alteraciones de textura, sangrado y retracción de las encías.");
		
		
		assertAll("ingresar,ver si esa cita está ,y borrar una cita",
				()->CitasDAO.insertarDatos(cita),
				()->assertFalse(CitasDAO.repeticionesMedico(12)==0),
				()->CitasDAO.eliminarCita(12,"12", "10", 1)
				);
	
	}

}
