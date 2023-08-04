package com.librarymanagementsystem.books;

import java.util.Map;

public interface BookCrudInterface {
    public void addBook(Book book);
    public void deleteBook(Book book);
    public Book getBook(Map<String,String> search);
    public Book updateBook(Book book);    
}
