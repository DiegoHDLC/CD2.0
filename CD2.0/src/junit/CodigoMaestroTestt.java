package junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.*;
import org.junit.jupiter.api.Test;

import classDAO.CodigoMaestroDAO;

class CodigoMaestroTestt {

	@Test
	void test() {
		String nulo=null;
		assertTrue(CodigoMaestroDAO.getCodigoMaestro().equals("1234"));
		assertFalse(!CodigoMaestroDAO.getCodigoMaestro().equals("1234"));
		assertEquals(CodigoMaestroDAO.getCodigoMaestro(),"1234");
		assertNotEquals(CodigoMaestroDAO.getCodigoMaestro(),"foo");
		//assertNull(ConnectCodigoMaestro.getCodigoMaestro());
		assertNotNull(CodigoMaestroDAO.getCodigoMaestro());
		
		//assertThrows(NullPointerException.class,()->ConnectCodigoMaestro.getCodigoMaestro());
		assertTimeout(Duration.ofMillis(50), () -> CodigoMaestroDAO.getCodigoMaestro());
		assertAll("Integrando varios assert",
		//()->	assertNull(ConnectCodigoMaestro.getCodigoMaestro()),
		()->	assertTrue(CodigoMaestroDAO.getCodigoMaestro().equals("1234")),
		()->	assertFalse(!CodigoMaestroDAO.getCodigoMaestro().equals("1234")),
		()->	assertEquals(CodigoMaestroDAO.getCodigoMaestro(),"1234"),
		()->	assertNotEquals(CodigoMaestroDAO.getCodigoMaestro(),"foo")
				);
	}

}
