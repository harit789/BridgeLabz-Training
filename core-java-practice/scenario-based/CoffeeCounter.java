package training;
import java.util.*;

public class CoffeeCounter {

    static Scanner sc = new Scanner(System.in);

    public static void askCoffee() {

        while (true) {
            System.out.print("\nEnter Coffee Name (or Exit): ");
            String coffeeName = sc.nextLine().toLowerCase().trim();

            if (coffeeName.equals("exit")) {
                System.out.println("Thank you! Visit again ☕");
                break;
            }

            int price = 0;

            switch (coffeeName) {
                case "mocha":
                    price = 100;
                    break;

                case "lattes":
                    price = 200;
                    break;

                case "breve":
                    price = 300;
                    break;

                case "cappuccino":
                    price = 400;
                    break;

                default:
                    System.out.println("Sorry! That coffee is not available.");
                    continue;
            }

            int bill = totalBill(price);
            applyGST(bill);
        }
    }

    public static int askQuantity() {
        System.out.print("Enter Quantity: ");
        return sc.nextInt();
    }

    public static int totalBill(int price) {
        int quantity = askQuantity();
        sc.nextLine(); 
        int total = price * quantity;
        System.out.println("Coffee Bill: " + total);
        return total;
    }

    public static void applyGST(int bill) {
        double gst = bill * 0.18;
        double totalAmount = bill + gst;

        System.out.println("GST (18%): " + gst);
        System.out.println("Total Amount: " + totalAmount);
    }

    public static void main(String[] args) {

        System.out.println("------- Coffee Menu -------");
        System.out.println("Mocha        - 100");
        System.out.println("Lattes       - 200");
        System.out.println("Breve        - 300");
        System.out.println("Cappuccino  - 400");
        System.out.println("Exit");

        askCoffee();
    }
}
