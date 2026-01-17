package annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted!");
    }
}

public class AccessControl {
	
	public static void main(String[] args) throws Exception {
		
        String currentUserRole = "USER";
        SecureService s = new SecureService();

        Method m = SecureService.class.getMethod("deleteUser");
        
        RoleAllowed allowed = m.getAnnotation(RoleAllowed.class);

        if (allowed.value().equals(currentUserRole)) {
            m.invoke(s);
        } else {
            System.out.println("Access Denied!");
        }
    }

}
