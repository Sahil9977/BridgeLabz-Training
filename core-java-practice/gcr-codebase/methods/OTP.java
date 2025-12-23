package methods;

public class OTP {
	 public static int generateOtp() {
	        return 100000 + (int)(Math.random() * 900000);
	    }

	    public static boolean areOtpsUnique(int[] otps) {
	        for (int i = 0; i < otps.length; i++) {
	            for (int j = i + 1; j < otps.length; j++) {
	                if (otps[i] == otps[j]) return false;
	            }
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        int[] otps = new int[10];
	        for (int i = 0; i < otps.length; i++) {
	            otps[i] = generateOtp();
	        }

	        System.out.println("Generated OTPs:");
	        for (int otp : otps) System.out.print(otp + " ");
	        System.out.println("\nAre OTPs unique? " + areOtpsUnique(otps));
	        
	    }

}
