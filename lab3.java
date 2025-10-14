import java.util.Scanner;

class Books {
    String name;
    String author;
    int price;
    int numPages;

    Books(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    public String toString() {
        String name = "Book name: " + this.name + "\n";
        String author = "Author name: " + this.author + "\n";
        String price = "Price: " + this.price + "\n";
        String numPages = "Number of pages: " + this.numPages + "\n";
        return name + author + price + numPages;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.print("Enter number of books: ");
        n = s.nextInt();

        Books[] b = new Books[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book " + (i + 1));
            System.out.print("Enter book name: ");
            String name = s.next();
            System.out.print("Enter author name: ");
            String author = s.next();
            System.out.print("Enter price: ");
            int price = s.nextInt();
            System.out.print("Enter number of pages: ");
            int numPages = s.nextInt();
            b[i] = new Books(name, author, price, numPages);
        }

        System.out.println("\nBooks details:");
        for (int i = 0; i < n; i++) {
            System.out.println(b[i].toString());
        }
        s.close();
    }
}
