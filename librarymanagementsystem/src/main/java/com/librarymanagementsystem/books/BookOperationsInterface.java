package com.librarymanagementsystem.books;

import java.sql.SQLException;

public interface BookOperationsInterface {
    public Book searchBookByAuthor(String author) throws SQLException;

    public Book searchBookByTitle(String title) throws SQLException;

    public Book searchBookByisbn(String isbn) throws SQLException;

    public Book insertBook(Book book) throws SQLException;

    public int deleteBook(String isbn) throws SQLException;

    public Book updateBook(Book book) throws SQLException;

}
