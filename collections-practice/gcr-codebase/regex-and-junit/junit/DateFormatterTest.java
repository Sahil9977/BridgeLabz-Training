
package junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("25-08-2025", formatter.formatDate("2025-08-25"));
        assertEquals("01-01-2020", formatter.formatDate("2020-01-01"));
    }

    @Test
    void testInvalidDateFormat() {   
        assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("25/08/2025"));
    }

    @Test
    void testNullDate() {
    	assertThrows(IllegalArgumentException.class, () ->  formatter.formatDate(null));
    }
}
