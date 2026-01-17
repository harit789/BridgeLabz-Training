import java.util.HashMap;
import java.util.Scanner;

public class BookShelf {
	public static void main(String args[]) {
		
		HashMap<String, BookList> bookShelf = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Add Books to Book Shelf");
			System.out.println("2.Delete Books from Book Shelf");
			System.out.println("3.Display");
			System.out.println("4.Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1 : 
				System.out.println("Enter Genre : ");
				String genre = sc.next();
				System.out.println("Enter Author : ");
				String author = sc.next();
				addToBookShelf(bookShelf, genre, author);
				break;
			case 2 : 
				System.out.println("Enter Genre : ");
				String genreDelete = sc.next();
				System.out.println("Enter author ");
				String authorDelete = sc.next();
				if(!bookShelf.containsKey(genreDelete)) {
					System.out.println("Genre Not found");
					break;
				}
				bookShelf.get(genreDelete).deleteBook(authorDelete);
				break;
			case 3 : 
				System.out.println("BOOK SHELF");
				displayBookShelf(bookShelf);
				break;
			case 4 :
				System.out.println("Thank You");
				return;
			default :
				System.out.println("Invalid Choice");
			}
			
		}


	}
	
	private static void addToBookShelf(HashMap<String, BookList> bookShelf, String genre, String author) {
		bookShelf.putIfAbsent(genre, new BookList());
		bookShelf.get(genre).addBook(author);
	}
	
	public static void displayBookShelf(HashMap<String , BookList> bookShelf) {
		for(String genre : bookShelf.keySet()) {
			System.out.println("Genre : "  + genre);
			bookShelf.get(genre).display();
		}
	}
}

class BookList{
	class BookNode{
		String author;
		BookNode next;
		
		public BookNode(String author) {
			this.author = author;
			this.next = null;
		}
	}
		private BookNode head;
		
		public void addBook( String author) {
			BookNode newBook = new BookNode(author);
			if(head == null) {
				head = newBook;
				return;
			} else {
				newBook.next = head;
				head = newBook;
			}
		}
		
		public void deleteBook(String author) {
			if(head == null) {
				System.out.println("No books to delete");
				return;
			}
			
			if(head.author.equals(author)) {
				head = head.next;
				return;
			}
			BookNode temp = head;
			while(temp.next != null) {
				if(temp.next.author.equals(author)) {
					temp.next = temp.next.next;
					break;
				}
				temp = temp.next;
			}
			
		}
		
		public void display() {
	        BookNode temp = head;
	        while (temp != null) {
	            System.out.println("Author: " + temp.author);
	            temp = temp.next;
	        }
	    }
}
