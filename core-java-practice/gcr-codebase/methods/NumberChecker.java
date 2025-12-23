package methods;

public class NumberChecker {
	 public static void main(String[] args) {
	        int num = 153;
	        int[] digits = getDigits(num);
	        System.out.println("Count: " + digits.length);
	        System.out.println("Duck: " + isDuck(digits));
	        System.out.println("Armstrong: " + isArmstrong(num, digits));
	        System.out.println("Largest: " + findLargest(digits));
	        System.out.println("Second Largest: " + findSecondLargest(digits));
	        System.out.println("Smallest: " + findSmallest(digits));
	        System.out.println("Second Smallest: " + findSecondSmallest(digits));
	    }

	    static int[] getDigits(int num) {
	        String s = Integer.toString(num);
	        int[] d = new int[s.length()];
	        for (int i = 0; i < s.length(); i++) d[i] = s.charAt(i) - '0';
	        return d;
	    }

	    static boolean isDuck(int[] digits) {
	        for (int d : digits) if (d == 0) return true;
	        return false;
	    }

	    static boolean isArmstrong(int num, int[] digits) {
	        int sum = 0;
	        for (int d : digits) sum += Math.pow(d, digits.length);
	        return num == sum;
	    }

	    static int findLargest(int[] digits) {
	        int max = Integer.MIN_VALUE;
	        for (int d : digits) if (d > max) max = d;
	        return max;
	    }

	    static int findSecondLargest(int[] digits) {
	        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
	        for (int d : digits) {
	            if (d > max) {
	                second = max;
	                max = d;
	            } else if (d > second && d != max) {
	                second = d;
	            }
	        }
	        return second;
	    }

	    static int findSmallest(int[] digits) {
	        int min = Integer.MAX_VALUE;
	        for (int d : digits) if (d < min) min = d;
	        return min;
	    }

	    static int findSecondSmallest(int[] digits) {
	        int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
	        for (int d : digits) {
	            if (d < min) {
	                second = min;
	                min = d;
	            } else if (d < second && d != min) {
	                second = d;
	            }
	        }
	        return second;
	    }

}
