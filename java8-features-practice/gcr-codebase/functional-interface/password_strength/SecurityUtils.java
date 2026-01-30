package functional_interface.password_strength;

public interface SecurityUtils {

    static boolean isStrongPassword(String password) {
        if (password == null) return false;
        
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*");
    }
}
