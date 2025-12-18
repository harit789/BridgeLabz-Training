import java.util.*;
public class ReaminderAndQuotient {
    public static void main(String[] args) {
        System.out.println("Enter number 1 : ");
        Scanner sc  = new Scanner(System.in);;
        int num1 = sc.nextInt();
        System.out.println("Enter number 2 : ");
        int num2 = sc.nextInt();
        System.out.println("The Quotient is " + (num1 / num2) + " and Reminder is " + (num1 % num2) + "of two number " + num1 + " and " + num2);
    }
}
