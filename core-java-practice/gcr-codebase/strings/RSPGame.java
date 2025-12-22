package strings;
import java.util.*;
public class RSPGame {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        String[][] results = new String[games][3];
        for (int i = 0; i < games; i++) {
            String user = sc.next();
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            results[i][0] = user;
            results[i][1] = computer;
            results[i][2] = winner;
        }

        System.out.println("User\tComputer\tWinner");
        for (int i = 0; i < games; i++) {
            System.out.println(results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2]);
        }
    }

    static String getComputerChoice() {
        String[] options = {"rock", "paper", "scissors"};
        return options[(int)Math.random()*3];
    }

    static String findWinner(String u, String c) {
        if (u.equals(c)) return "Draw";
        if ((u.equals("rock") && c.equals("scissors")) ||
            (u.equals("scissors") && c.equals("paper")) ||
            (u.equals("paper") && c.equals("rock"))) return "User";
        return "Computer";
    }

}
