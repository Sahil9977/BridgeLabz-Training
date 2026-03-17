package MT_PRACTICE;

import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord {
	String name;
	String department;
	int q1;
	int q2;
	int q3;

	public StudentRecord(String name, String department, int q1, int q2, int q3) {
		this.name = name;
		this.department = department;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
	}
}

public class QuizPerformance {

	static ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();

	public static void add(String name, String department, int q1, int q2, int q3) {
		if (list.add(new StudentRecord(name, department, q1, q2, q3)))
			System.out.println("Record Added : " + name);
	}

	public static void topD(String department) {
		int max = 0;
		String name = "";
		if (list.isEmpty())
			System.out.println("No Records Available");
		else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).department.equals(department)) {
					if (max < (list.get(i).q1 + list.get(i).q2 + list.get(i).q3)) {
						max = list.get(i).q1 + list.get(i).q2 + list.get(i).q3;
						name = list.get(i).name;
					}
				}
			}
			if(max==0 && name.length()==0)System.out.println("Department Not Found");
			else System.out.println(name + " " + max);
		}
	}

	public static void topQ(String q) {
		int max = 0;
		if (list.isEmpty()) {
			System.out.println("No Records Available");

		} else if (q.equals("Q1")) {

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q1 > max)
					max = list.get(i).q1;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q1 == max) {
					System.out.println(list.get(i).name + " " + list.get(i).q1);
				}
			}
		} else if (q.equals("Q2")) {

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q2 > max)
					max = list.get(i).q2;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q2 == max) {
					System.out.println(list.get(i).name + " " + list.get(i).q2);
				}
			}
		} else if (q.equals("Q3")) {

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q3 > max)
					max = list.get(i).q3;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).q3 == max) {
					System.out.println(list.get(i).name + " " + list.get(i).q3);
				}
			}
		} else {
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String [] arr = s.split(" ");
			if(arr[0].equals("Record"))
				add(arr[1], arr[2], Integer.parseInt(arr[3]),
						Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
			else if(arr[0].equals("Top")) {
				if(arr[1].length()==2)topQ(arr[1]);
				else topD(arr[1]);
			}else {}

		}
	}

}
