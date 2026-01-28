import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Customer{
	List<Item> items;
	
	public Customer (List<Item> items) {
		this.items = items;
	}
}

class Item{
	String name; 
	
	public Item(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Item [ Name : " + name  + " ]";
	}
}

class ItemDetail{
	int stock;
	int price;
	
	public ItemDetail(int stock, int price) {
		this.stock = stock;
		this.price = price;
	}
}
public class SmartCheckout {
	public static void main(String args[]) {
		Queue<Customer> list = new LinkedList<>();
		
		HashMap<String, ItemDetail> itemsMap = new HashMap<>();
		
		itemsMap.put("Milk", new ItemDetail(2, 25));
		itemsMap.put("Bread", new ItemDetail(5, 55));
		
		list.add(new Customer(List.of(new Item("Milk") , new Item("Bread"))));
		list.add(new Customer(List.of(new Item("Bread"))));
		
		while(!list.isEmpty()) {
			Customer customer = list.poll();
			int totalPrice = 0;
			
			for(Item item : customer.items) {
				ItemDetail details = itemsMap.get(item.name);
				
				if(details != null && details.stock > 0) {
					totalPrice += details.price;
					details.stock--;
				} else {
					System.out.println(item.name + " is out of stock");
				}
				
				System.out.println("Total Price of " + item.name + " is " + totalPrice);
			}
		}
	}
}
