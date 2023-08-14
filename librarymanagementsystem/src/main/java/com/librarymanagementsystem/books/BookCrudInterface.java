package com.librarymanagementsystem.books;

import java.sql.SQLException;
import java.util.Map;

public interface BookCrudInterface {
    public int addBook(Book book) throws SQLException;
    public int deleteBook(String isbn) throws SQLException;
    public Book getBook(Map<String,String> search) throws SQLException;
    public Book updateBook(Book book) throws SQLException;    
}
