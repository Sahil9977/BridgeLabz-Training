package strings;
import java.util.Scanner;
public class SplitText2Words {
	public static String[][] splitWords(String line) {
        String[] words = line.split(" ");
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = Integer.toString(words[i].length());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[][] result = splitWords(line);
        for (int i = 0; i < result.length; i++) {
            System.out.println( result[i][0]+" "+  result[i][1]);
        }
    }

}
