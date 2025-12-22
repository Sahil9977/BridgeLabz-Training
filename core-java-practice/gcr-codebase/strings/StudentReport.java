package strings;
import java.util.*;
public class StudentReport {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = assignGrades(results);
        displayScorecard(scores, results, grades);
    }

    static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 +(int) Math.random()*61;
            scores[i][1] = 40 +(int) Math.random()*61;
            scores[i][2] = 40 +(int) Math.random()*61;
        }
        return scores;
    }

    static double[][] calculateResults(int[][] scores) {
        double[][] res = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double per = (total / 300.0) * 100;
            res[i][0] = Math.round(total);
            res[i][1] = Math.round(avg);
            res[i][2] = Math.round(per);
        }
        return res;
    }

    static String[] assignGrades(double[][] res) {
        String[] grades = new String[res.length];
        for (int i = 0; i < res.length; i++) {
            double p = res[i][2];
            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else if (p >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    static void displayScorecard(int[][] s, double[][] r, String[] g) {
        System.out.printf("%-5s%-10s%-10s%-10s%-10s%-10s%-10s%-5s\n", "Roll", "Physics", "Chem", "Math", "Total", "Avg", "Percent", "Grade");
        for (int i = 0; i < s.length; i++) {
            System.out.printf("%-5d%-10d%-10d%-10d%-10.0f%-10.0f%-10.0f%-5s\n",
                    i + 1, s[i][0], s[i][1], s[i][2], r[i][0], r[i][1], r[i][2], g[i]);
        }
    }

}
