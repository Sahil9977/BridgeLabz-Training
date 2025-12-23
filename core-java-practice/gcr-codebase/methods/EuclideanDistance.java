package methods;
import java.util.*;
public class EuclideanDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        double x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
        double distance = euclideanDistance(x1, y1, x2, y2);
        double[] eq = lineEquation(x1, y1, x2, y2);
        System.out.println("Distance: " + distance);
        System.out.println("Equation: y = " + eq[0] + "x + " + eq[1]);
    }

    static double euclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[]{m, b};
    }

}
