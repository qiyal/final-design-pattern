package sample.databases;

import sample.models.products.Book;
import sample.models.products.BookGenreEnum;
import sample.models.products.BookPublisherEnum;

import java.util.*;

public class BookDatabase {
    private static BookDatabase instance;
    private SortedMap<Integer, Book> books = new TreeMap<>();

    {
        Set<String> setNames = new HashSet<>();
        setNames.add("Douglas Noël Adams");

        Book b1 = new Book(1, "The Hitchhiker’s Guide to the Galaxy", setNames, 1260,
                BookGenreEnum.SCIENCE_FICTION, 2014, BookPublisherEnum.ACT, 10, 1, 1, "book1.jpg");

        Book b2 = new Book(2, "The Restaurant at the End of the Universe", setNames, 2100,
                BookGenreEnum.SCIENCE_FICTION, 2017, BookPublisherEnum.ACT, 5, 1, 2, "book2.jpg");

        setNames.clear();
        setNames.add("Antoine Marie Jean-Baptiste Roger de Saint-Exupéry");
        Book b3 = new Book(3, "Le Petit Prince", setNames, 990,
                BookGenreEnum.PROSE, 2017, BookPublisherEnum.EKSMO, 2, 3, 1, "book3.jpg");

        setNames.clear();
        setNames.add("Eric Berne");
        Book b4 = new Book(4, "Games People Play", setNames, 2500,
                BookGenreEnum.PSYCHOLOGY, 2017, BookPublisherEnum.EKSMO, 0, 4, 1, "book4.jpg");

        setNames.clear();
        setNames.add("Brian Tracy");
        Book b5 = new Book(5, "THE SCIENCE OF MOTIVATION", setNames, 2300,
                BookGenreEnum.PSYCHOLOGY, 2018, BookPublisherEnum.EKSMO, 0, 5, 1, "book5.jpg");

        setNames.clear();
        setNames.add("Stephen Edwin King");
        Book b6 = new Book(6, "It", setNames, 4390,
                BookGenreEnum.FANTASY, 2015, BookPublisherEnum.ACT, 100, 6, 1, "book6.jpg");

        setNames.clear();
        setNames.add("Joanne Katheline Rowling");
        Book b7 = new Book(7, "Harry Potter and the Philosopher's Stone", setNames, 4390,
                BookGenreEnum.PROSE, 2019, BookPublisherEnum.STEPPE, 20, 7, 1, "book7.jpg");

        Book b8 = new Book(8, "Harry Potter and the Chamber of Secrets", setNames, 4200,
                BookGenreEnum.PROSE, 2020, BookPublisherEnum.STEPPE, 0, 7, 2, "book8.jpg");

        books.put(b1.getBookId(), b1);
        books.put(b2.getBookId(), b2);
        books.put(b3.getBookId(), b3);
        books.put(b4.getBookId(), b4);
        books.put(b5.getBookId(), b5);
        books.put(b6.getBookId(), b6);
        books.put(b7.getBookId(), b7);
        books.put(b8.getBookId(), b8);
    }

    private BookDatabase() {}

    public static BookDatabase getInstance() {
        if (instance == null)
            instance = new BookDatabase();
        return instance;
    }

    public ArrayList<Book> getBooksByOnly(int pageNumber) {
        ArrayList<Book> pageBooks = new ArrayList<>(books.values());
        ArrayList<Book> result = new ArrayList<>();

        for (int i = 6 * (pageNumber - 1); i < books.size() && i < 6 * pageNumber; i++) {
            result.add(pageBooks.get(i));
        }
        return result;

    }

    public int size() {
        return books.size();
    }


}
