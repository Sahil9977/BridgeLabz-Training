package methods;
import java.util.Scanner;
public class StudentReport {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        printScorecard(scores, results);
    }

    static int[][] generateScores(int n) {
        int[][] pcm = new int[n][3];
        for (int i = 0; i < n; i++) {
            pcm[i][0] = 40 + (int)Math.random()*61;
            pcm[i][1] = 40 + (int)Math.random()*61;
            pcm[i][2] = 40 + (int)Math.random()*61;
        }
        return pcm;
    }

    static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            results[i][0] = Math.round(total);
            results[i][1] = Math.round(avg);
            results[i][2] = Math.round(percent);
        }
        return results;
    }

    static void printScorecard(int[][] scores, double[][] results) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s%n", "Roll", "Physics", "Chemistry", "Math", "Total", "Average", "Percent");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d%-10d%-10d%-10d%-10.0f%-10.0f%-10.0f%n", i + 1, scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2]);
        }
    }

}
