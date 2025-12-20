import java.util.Scanner;

public class FriendsCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt();
        int age2 = sc.nextInt();
        int age3 = sc.nextInt();
        int height1 = sc.nextInt();
        int height2 = sc.nextInt();
        int height3 = sc.nextInt();

        int youngest =0;;
        if(age1<age2){
            if(age1<age3)youngest=age1;
            else if(age3 < age2) youngest=age3;
            else{}
        }
        else if(age2<age3)youngest=age2;
        else if (age3<age1)youngest=age3;
        else{}

        int tallest = 0;
        if(height1>height2){
            if(height1>height3)tallest=height1;
            else if(height3 > height2) tallest=height3;
            else{}
        }
        else if(height2>height3)tallest=height2;
        else if (height3>height1)tallest=height3;
        else{}

        System.out.println("Youngest age: " + youngest);
        System.out.println("Tallest height: " + tallest);
    }
}
