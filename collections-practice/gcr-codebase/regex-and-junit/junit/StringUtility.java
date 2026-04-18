
package junit;
import org.junit.jupiter.api.Test;

public class StringUtility {
	String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();	
	}
	boolean isPalindrome(String str) {
		if(str.equals(reverse(str))) return true;
		return false;
	}
	String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
