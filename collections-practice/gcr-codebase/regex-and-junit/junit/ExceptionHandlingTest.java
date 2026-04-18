package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class ExceptionHandlingTest {
	ExceptionHandling eh = new ExceptionHandling();
	@Test
	void testDivide() {
		assertEquals(5, eh.divide(10, 2));
	}
	
	@Test
	void testException() {
		assertThrows( ArithmeticException.class, ()->eh.divide(8, 0));
	}
}
