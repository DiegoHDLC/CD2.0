package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import utils.MySQLConexion;

class SqlConexionTest {

	@Test
	void test() {
		
		assertNotNull(MySQLConexion.getConexion());
		try {
			(MySQLConexion.getConexion()).close();
		} catch (SQLException e) {
			
		}
		
		
	}

}
