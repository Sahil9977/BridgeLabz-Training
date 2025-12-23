package methods;

public class NumberUsing2D {
	 public static void main(String[] args) {
	        int num = 210;
	        int[] digits = getDigits(num);
	        System.out.println("Count: " + digits.length);
	        System.out.println("Sum of digits: " + sumDigits(digits));
	        System.out.println("Sum of squares: " + sumSquares(digits));
	        System.out.println("Harshad: " + isHarshad(num, digits));
	        printFrequency(digits);
	    }

	    static int[] getDigits(int num) {
	        String s = Integer.toString(num);
	        int[] d = new int[s.length()];
	        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
	        return d;
	    }

	    static int sumDigits(int[] digits) {
	        int sum = 0;
	        for (int d : digits) sum += d;
	        return sum;
	    }

	    static int sumSquares(int[] digits) {
	        int sum = 0;
	        for (int d : digits) sum += Math.pow(d, 2);
	        return sum;
	    }

	    static boolean isHarshad(int num, int[] digits) {
	        int sum = sumDigits(digits);
	        return num % sum == 0;
	    }

	    static void printFrequency(int[] digits) {
	        int[][] freq = new int[10][2];
	        for (int i = 0; i < 10; i++) freq[i][0] = i;
	        for (int d : digits) freq[d][1]++;
	        for (int i = 0; i < 10; i++) {
	            if (freq[i][1] > 0)
	                System.out.println(freq[i][0] + " " + freq[i][1]);
	        }
	    }

}
