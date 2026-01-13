
package junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    PasswordValidator pv = new PasswordValidator();

    @Test
    void testValidPasswords() {
        assertTrue(pv.isValid("Password1"));
        assertTrue(pv.isValid("Abcdefg9H"));
    }

    @Test
    void testInvalidPasswordsTooShort() {
        assertFalse(pv.isValid("Abc1"));
    }

    @Test
    void testInvalidPasswordsNoUppercase() {
        assertFalse(pv.isValid("password1"));
        assertFalse(pv.isValid("abcd1234"));
    }

    @Test
    void testInvalidPasswordsNoDigit() {
        assertFalse(pv.isValid("Password"));
        assertFalse(pv.isValid("ABCDEFGH"));
    }
    @Test
    void testNullPassword() {
        assertFalse(pv.isValid(null));
    }
}
