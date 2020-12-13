package sample.models;

import java.util.Set;

public class Book extends Product {
    private long bookId;
    private String name;
    private Set<String> authorName;
    private int price;
    private String genre;
    private int year;
    private String publisher;
    private int quantity;
    private String series;

    public Book() {}

    public Book(long bookId, String name, Set<String> authorName, int price, String genre, int year, String publisher, int quantity, String series) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.genre = genre;
        this.year = year;
        this.publisher = publisher;
        this.quantity = quantity;
        this.series = series;
    }

    public long getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAuthorName() {
        return authorName;
    }

    public int getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSeries() {
        return series;
    }
}
