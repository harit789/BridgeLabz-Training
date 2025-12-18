import java.util.*;
public class KmToMile {
     public static void main(String[] args) {
        System.out.print("Kilometers : ");
        Scanner sc = new Scanner(System.in);
        int km = sc.nextInt();
        double miles = km *1.6;
        System.out.println("The total miles is  " + miles + " mile for the given  " + km + " km");
    }
}
