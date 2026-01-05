package reviews;

import java.util.Scanner;

class Product{
	String productName;
	int productPrice;
	
	public Product(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
		}
	
	void display() {
		System.out.println("Product Name : " + productName);
		System.out.println("Product Price : " + productPrice);
	}
}

class Order extends Product{
	int orderId;
	
	public Order(String productName, int productPrice, int orderId) {
		super(productName, productPrice);
		this.orderId = orderId;
	}
	
	void display() {
		super.display();
		System.out.println("Order id : " + orderId);
	}
}

interface payment{
	void pay();
}

class PayCard implements payment{
	Scanner sc = new Scanner(System.in);
	public void pay() {
		System.out.println("Enter your Card Details");
		System.out.print("Card Number : ");
		int cardNo = sc.nextInt();
		System.out.print("Expiry Date : ");
		int expiryDate = sc.nextInt();
		System.out.print("cvv : ");
		int cvv = sc.nextInt();
	}
}
class PayUPI implements payment{
	Scanner sc = new Scanner(System.in);
	public void pay() {
		System.out.println("Enter upi : ");
		String upi = sc.next();
	}
}
class PayWallet implements payment{
	Scanner sc = new Scanner(System.in);
	public void pay() {
		System.out.println("Enter wallet Details : " );
		int wallet = sc.nextInt();
	}
}	



public class ECommerceManagement {
	class OrderNode{
		String productName;
		int productPrice;
		int orderId;
		OrderNode next;
		
		public OrderNode(String productName, int productPrice, int orderId) {
			this.productName = productName;
			this.productPrice = productPrice;
			this.orderId = orderId;
			this.next = null;
		}
	}
	
	class OrderItems{
		private OrderNode head;
		
		public void addOrder(String productName, int productPrice, int orderId) {
			OrderNode newOrder = new OrderNode(productName, productPrice, orderId);
			if(head == null) {
				head = newOrder;
				return;
			}
			newOrder.next = head;
			head = newOrder;
		}
		
		public void deleteOrder(int orderId) {
			OrderNode temp = head;
			
			if(head == null ) {
				System.out.println("Order not found");
				return;
			}
			if(head.orderId == orderId) {
				head = head.next;
				return;
			}
			while( temp.next != null && temp.next.orderId != orderId) {
				temp = temp.next;
			}

			temp.next = temp.next.next;
		}
		
		public void updateOrder(String productName, int productPrice, int orderId) {
			OrderNode temp = head;
			while(temp != null && temp.orderId != orderId) {
				temp = temp.next;
			}
			if(temp == null) {
				System.out.println("Order not found");
			}
		    temp.productName = productName;
		    temp.productPrice = productPrice;
		}
		
		public void displayOrder() {
			OrderNode temp = head;
			while(temp != null) {
				System.out.println(
						"Product Name : " + temp.productName +
						" Product Price : "  + temp.productPrice +
						" Order Id : " + temp.orderId 
						);
				temp = temp.next;
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ECommerceManagement em = new ECommerceManagement();
        OrderItems orders = em.new OrderItems();

        System.out.print("Enter Product Name : ");
        String name = sc.next();

        System.out.print("Enter Product Price : ");
        int price = sc.nextInt();

        System.out.print("Enter Order Id : ");
        int id = sc.nextInt();

        orders.addOrder(name, price, id);
        System.out.println("1. Card  2. UPI  3. Wallet");
        int choice = sc.nextInt();

        payment p;
        if (choice == 1) {
            p = new PayCard();
        } else if (choice == 2) {
            p = new PayUPI();
        } else {
            p = new PayWallet();
        }

        p.pay();
        orders.displayOrder();
	}
}
