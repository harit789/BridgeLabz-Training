package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
	String name;
	double price;
	int quantity;

	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	abstract void display();

	abstract double totalValue();
}

class Electronics extends Product {
	int warranty;

	public Electronics(String name, double price, int quantity, int warranty) {
		super(name, price, quantity);
		this.warranty = warranty;
	}

	public void display() {
		System.out.println(
				name + " - Price: " + price + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
	}

	public double totalValue() {
		return price * quantity;
	}
}

class Clothing extends Product {
	String size;

	public Clothing(String name, double price, int quantity, String size) {
		super(name, price, quantity);
		this.size = size;
	}

	public void display() {
		System.out.println(name + " - Price: " + price + ", Quantity: " + quantity + ", Size: " + size);
	}

	public double totalValue() {
		return price * quantity;
	}
}

public class InventorySystem {
	private List<Product> list = new ArrayList<>();

	public void addProduct(Product product) {
		list.add(product);
	}

	public void output() {
		for (Product p : list) {
			System.out.println("Product added to inventory: " + p.name);
		}

		System.out.println();
		System.out.println("Inventory:");
		for (Product p : list) {
			p.display();
		}
		System.out.println();
		double sum = 0;
		for (Product p : list) {
			sum += p.totalValue();
		}
		System.out.printf("Total Value of the inventory: %.2f" , sum);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		InventorySystem util = new InventorySystem();
		int n = sc.nextInt();
		String[] inputArr = new String[n];
		sc.nextLine();
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = sc.nextLine();
		}

		for (int i = 0; i < inputArr.length; i++) {
			String[] inputSplit = inputArr[i].split("\\,");
			if (inputSplit[0].equals("Electronics")) {
				Electronics electronics = new Electronics(inputSplit[1].trim(), Double.parseDouble(inputSplit[2].trim()),
						Integer.parseInt(inputSplit[3].trim()), Integer.parseInt(inputSplit[4].trim()));
				util.addProduct(electronics);
			} else if (inputSplit[0].equals("Clothing")) {
				Clothing clothing = new Clothing(inputSplit[1].trim(), Double.parseDouble(inputSplit[2].trim()),
						Integer.parseInt(inputSplit[3].trim()), inputSplit[4].trim());
				util.addProduct(clothing);
			}
		}
		util.output();
	}
}
