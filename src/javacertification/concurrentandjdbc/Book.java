package javacertification.concurrentandjdbc;

public class Book {
    String isbn;
    double price;

    Book (String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    public String toString () {
        return "Book[" + isbn + ":" + price + "]";
    }
}
