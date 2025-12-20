
import java.util.*;

public class BMI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] h = new double[n];
        double[] w = new double[n];
        double[] bmi = new double[n];
        String[] ws = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("person" + (i + 1));
            System.out.println("Enter the height");
            h[i] = sc.nextDouble();
            System.out.println("Enter the weight");
            w[i] = sc.nextDouble();
            bmi[i] = w[i] / (h[i] * h[i]);

            if (bmi[i] <= 18.4) {
                ws[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                ws[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                ws[i] = "Overweight";
            } else {
                ws[i] = "Obese";
            }
        }
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d => Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s\n",
                    (i + 1), h[i], w[i], bmi[i], ws[i]);
        }

    }

}
