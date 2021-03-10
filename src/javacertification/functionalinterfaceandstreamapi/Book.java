package javacertification.functionalinterfaceandstreamapi;

public class Book {
    String book;
    String author;
    double price;

    public Book(String book, String author, double price) {
        this.book = book;
        this.author = author;
        this.price = price;
    }

    public String getAuthor () {
        return this.author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book='" + book + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
