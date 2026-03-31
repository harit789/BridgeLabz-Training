import java.util.*;
public class UniversityFees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fees : ");
        int fee = sc.nextInt();
        System.out.print("Discount : ");
        int discountPercent = sc.nextInt();
        int discountFee = fee * discountPercent/100;
        int remainFee = fee - discountFee;
        System.out.println("The discount amount is INR " + discountFee +" and final discounted fee is INR " + remainFee);
    }
}
