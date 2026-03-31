public class UniversityFee {
    public static void main(String[] args) {
        int fee = 125000;
        int discount = 125000 * 10/100;
        int discountFee = 125000 - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountFee);
    }
}
