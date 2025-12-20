package training;
import java.util.*;

public class FitnessTracker {
	
	public static double  bmiCal(int height, int weight) {
		return weight / (height * height);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Weight : ");
		int weight = sc.nextInt();
		System.out.println("Enter Height : ");
		int height = sc.nextInt();
		
		double bmi = bmiCal(height, weight);
		
		 if (bmi < 18.5) {
	            System.out.println("Underweight");
	        } 
	        else if (bmi >= 18.5 && bmi < 25) {
	            System.out.println("Normal");
	        } 
	        else {
	            System.out.println("Overweight");
	        }
		}
}
