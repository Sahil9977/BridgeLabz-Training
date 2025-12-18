import java.util.Scanner;

public class volume_of_cylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the cylinder");
        int radius = sc.nextInt();
        System.out.println("Enter the height of the cylinder");
        int height = sc.nextInt();
        double Volume = 3.14*radius*radius*height;
        System.out.println("Volume of Cylinder" + Volume);
    }
}
