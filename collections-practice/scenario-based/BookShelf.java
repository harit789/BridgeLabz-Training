import java.util.HashMap;
import java.util.Scanner;

public class BookShelf {

    public static void main(String[] args) {

        HashMap<String, BookList> bookShelf = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Return Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Display Bookshelf");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            String genre;
            String author;

            switch (choice) {

                case 1:
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    addToBookShelf(bookShelf, genre, author);
                    System.out.println("Book added.");
                    break;

                case 2:
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    deleteBook(bookShelf, genre, author);
                    break;

                case 3:
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    addToBookShelf(bookShelf, genre, author);
                    System.out.println("Book returned.");
                    break;

                case 4:
                    System.out.print("Enter Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    deleteBook(bookShelf, genre, author);
                    System.out.println("Book borrowed.");
                    break;

                case 5:
                    displayBookShelf(bookShelf);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addToBookShelf(HashMap<String, BookList> bookShelf,
                                       String genre, String author) {
        bookShelf.putIfAbsent(genre, new BookList());
        bookShelf.get(genre).addBook(author);
    }

    private static void deleteBook(HashMap<String, BookList> bookShelf,
                                   String genre, String author) {

        if (!bookShelf.containsKey(genre)) {
            System.out.println("Genre not found.");
            return;
        }

        BookList list = bookShelf.get(genre);
        boolean removed = list.deleteBook(author);

        if (!removed) {
            System.out.println("Book not found.");
        }

        if (list.isEmpty()) {
            bookShelf.remove(genre);
        }
    }

    private static void displayBookShelf(HashMap<String, BookList> bookShelf) {
        if (bookShelf.isEmpty()) {
            System.out.println("Bookshelf is empty.");
            return;
        }

        System.out.println("\nBOOK SHELF:");
        for (String genre : bookShelf.keySet()) {
            System.out.println("Genre: " + genre);
            bookShelf.get(genre).display();
        }
    }
}

class BookList {

    class BookNode {
        String author;
        BookNode next;

        BookNode(String author) {
            this.author = author;
        }
    }

    private BookNode head;

    public void addBook(String author) {
        BookNode newBook = new BookNode(author);
        newBook.next = head;
        head = newBook;
    }

    public boolean deleteBook(String author) {
        if (head == null) return false;

        if (head.author.equals(author)) {
            head = head.next;
            return true;
        }

        BookNode temp = head;
        while (temp.next != null) {
            if (temp.next.author.equals(author)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println("  Author: " + temp.author);
            temp = temp.next;
        }
    }
}
