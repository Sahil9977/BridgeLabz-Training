package Review;

public class ImplementThisSuper {
    static class Student {
        private String name;
        private int rollNo;

        public Student(String name, int rollNo) {
            this.name = name;
            this.rollNo = rollNo;
        }
        public void display() {
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
        }
    }
    static class CollegeStudent extends Student {
        private String course;
        public CollegeStudent(String name, int rollNo, String course) {
            super(name, rollNo);   
            this.course = course;
        }
        public void show() {
            super.display();    
            System.out.println("Course: " + course);
        }
    }

    public static void main(String[] args) {
        CollegeStudent cs = new CollegeStudent("Rahul", 101, "B.Tech");
        cs.show();
    }
}
