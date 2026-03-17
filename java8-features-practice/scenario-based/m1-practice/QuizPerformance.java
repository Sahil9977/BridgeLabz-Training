package MT_PRACTICE;

import java.util.ArrayList;
import java.util.Scanner;

class StudentRecord{
	String name;
	String department;
	int q1 ;
	int q2;
	int q3;
	
	public StudentRecord(String name,String department,int q1,int q2,int q3) {
		this.name=name;
		this.department=department;
		this.q1=q1;
		this.q2=q2;
		this.q3=q3;
	}
}
public class QuizPerformance {
	
	static ArrayList<StudentRecord> list= new ArrayList<StudentRecord>();
	
	public static void add(String name , String department, int q1,int q2,int q3) {
		if( list.add(new StudentRecord(name, department, q1, q2, q3))) System.out.println("Record Added : "+name);
	}
	
	public static void top(String department) {
		int max =0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).department.equals(department)) {
				if(max<(list.get(i).q1+list.get(i).q2+list.get(i).q3))max=list.get(i).q1+list.get(i).q2+list.get(i).q3;
			}
		}
	}
	public static void main(String[] args) {

		
		Scanner sc= new Scanner(System.in);
		
		int n=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			
			
		}
	}
 
}
