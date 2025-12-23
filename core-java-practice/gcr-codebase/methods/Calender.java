package methods;
import java.util.*;
public class Calender {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int year = sc.nextInt();
		printCalender(month,year);
	}
	public static void printCalender(int month,int year) {
		String [] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
		 int[] days = {31, isLeap(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		 System.out.printf("     %s %d\n", months[month - 1], year);
	     System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		 int d = algo(1,month,year);//first day of the month 
		 
		 for (int i = 0; i < d; i++) System.out.print("    ");
	     for (int i = 1; i <= days[month - 1]; i++) {
	            System.out.printf("%3d ", i);
	            if ((i + d) % 7 == 0) System.out.println();
	     }
		
	}
	public static boolean isLeap(int y) {
		return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
	}
	static int algo(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        return (d + x + 31 * m0 / 12) % 7;
    }

}
