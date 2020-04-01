package junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import mantenimientos.WolframExecute;

class WolframBarchartTest {

	@Test
	void test() {
		String param1="7,194";
		String param2="continentes,paises";
		assertAll(
		"",
		()->assertTrue(WolframExecute.barchar(param1, param2)!=null),
		()->assertTrue(WolframExecute.barchar(param1, param2) instanceof ImageIcon)
		);
		
	}

}
