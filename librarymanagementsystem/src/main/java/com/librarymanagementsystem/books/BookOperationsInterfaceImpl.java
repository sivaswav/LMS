package com.librarymanagementsystem.books;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BookOperationsInterfaceImpl implements BookOperationsInterface {

    private BookCrudInterface bookCrudInterface;

    public BookOperationsInterfaceImpl(BookCrudInterface bookCrudInterface) {
        this.bookCrudInterface = bookCrudInterface;
    }

    @Override
    public Book searchBookByAuthor(String author) throws SQLException {
        Map<String, String> search = new HashMap<>();
        search.put("author", author);
        System.out.println(bookCrudInterface);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book searchBookByTitle(String title) throws SQLException {
        Map<String, String> search = new HashMap<>();
        search.put("title", title);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book searchBookByisbn(String isbn) throws SQLException {
        Map<String, String> search = new HashMap<>();
        search.put("isbn", isbn);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book insertBook(Book book) throws SQLException {
        Map<String, String> search = new HashMap<>();
        search.put("isbn", book.getIsbn());
        bookCrudInterface.addBook(book);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public int deleteBook(String isbn) throws SQLException {
        return bookCrudInterface.deleteBook(isbn);
    }

    @Override
    public Book updateBook(Book book) throws SQLException {
        return bookCrudInterface.updateBook(book);

    }

}
