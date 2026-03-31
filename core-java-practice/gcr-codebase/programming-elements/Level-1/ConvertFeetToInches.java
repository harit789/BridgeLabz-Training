import java.util.Scanner;
public class ConvertFeetToInches {
    public static void main(String[] args) {
        System.out.print("Enter height : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        double inches = height * 2.54;
        double foot = inches * 12;
        System.out.println("Your Height in cm is " + height+ " while in feet is " + foot +" and inches is " + inches);
    }
}