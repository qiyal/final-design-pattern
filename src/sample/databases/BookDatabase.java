package sample.databases;

import sample.models.Book;

import java.util.*;

public class BookDatabase {
    private static BookDatabase instance;
    private SortedMap<Long, Book> books = new TreeMap<>();

    {
        Set<String> st = new HashSet<>();
        st.add("Дуглас Адамс");

        Book b1 = new Book(1, "The Hitchhiker’s Guide to the Galaxy", )
    }

    private BookDatabase() {}

    public static BookDatabase getInstance() {
        if (instance == null)
            instance = new BookDatabase();
        return instance;
    }


}
