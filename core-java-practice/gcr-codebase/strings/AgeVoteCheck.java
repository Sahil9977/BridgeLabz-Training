package strings;

public class AgeVoteCheck {
	public static int[][] generateAges(int students) {

        int[][] data = new int[students][2];
        for (int i = 0; i < students; i++) {
            data[i][0] = 15 + (int)Math.random()*10; 
            data[i][1] = data[i][0] >= 18 ? 1 : 0;
        }
        return data;
    }

    public static void main(String[] args) {
        int[][] students = generateAges(10);
        for (int i = 0; i < students.length; i++) {
            System.out.println( i + 1+" "+students[i][0]+" "+ (students[i][1] == 1 ? "Yes" : "No")
            		);
        }
    }

}
