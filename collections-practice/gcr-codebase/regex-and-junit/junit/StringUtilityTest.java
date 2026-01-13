package junit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class StringUtilityTest {
	
	StringUtility su = new StringUtility();
	@Test
	void testReverse() {
		assertEquals("las", su.reverse("sal"));
	}
	
	@Test
	void testisPallindrome() {
		assertEquals(true, su.isPalindrome("lol"));
	}
	
	@Test
	void testToUpperCase() {
		assertEquals("LOL", su.toUpperCase("lol"));
	}
}
