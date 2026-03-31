import java.util.Scanner;

public class Quantity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the quantity : ");
        int quantity = sc.nextInt();
        System.out.println("Enter the unit price : ");
        int unitPrice = sc.nextInt();
        System.out.println("The total purchase price is INR "+(unitPrice * quantity) + " if the quantity "+ quantity+ " and unit price is INR " +unitPrice);
    }
}
