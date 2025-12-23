package methods;
import java.util.Scanner;
public class Roots {
	public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        double ans [] = new double[2];
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) {
            System.out.println("No real roots");
        } else {
            for (double root : roots) {
                System.out.println("Root: " + root);
            }
        }
    }

}
