import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base: ");
        double base = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaIn = areaCm / 6.4516;
        System.out.println("The Area of the triangle in sq in is " + areaIn + " and sq cm is " + areaCm);
    }
}
