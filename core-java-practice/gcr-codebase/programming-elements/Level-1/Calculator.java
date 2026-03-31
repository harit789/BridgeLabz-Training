import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Num1 : ");
        float num1 = sc.nextFloat();
        System.out.println("Num2 : ");
        float num2 = sc.nextFloat();
        float add = num1 + num2;
        float mul = num1 * num2;
        float sub = num1 - num2;
        float div = num1 / num2;
        System.out.println(" The addition, subtraction, multiplication and division value of 2 numbers " + num1 + " and " + num2 + " is "+ add + " , " + sub + " , " + mul + " and " + div);
    }
}
