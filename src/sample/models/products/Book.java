package sample.models.products;

import java.util.Set;

public class Book extends Product {
    private int bookId;
    private String name;
    private Set<String> authorName;
    private int price;
    private BookGenreEnum genre;
    private int year;
    private BookPublisherEnum publisher;
    private int quantity;
    private int idPart;
    private int part;
    private String urlImage;

    public Book() {}

    public Book(int bookId, String name, Set<String> authorName, int price, BookGenreEnum genre, int year, BookPublisherEnum publisher, int quantity, int idPart, int part, String urlImage) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.genre = genre;
        this.year = year;
        this.publisher = publisher;
        this.quantity = quantity;
        this.idPart = idPart;
        this.part = part;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public int getBookId() {
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

    public BookGenreEnum getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public BookPublisherEnum getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdPart() {
        return idPart;
    }

    public int getPart() {
        return part;
    }
}
