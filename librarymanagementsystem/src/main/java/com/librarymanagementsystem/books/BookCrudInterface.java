package com.librarymanagementsystem.books;

import java.util.Map;

public interface BookCrudInterface {
    public void addBook(Book book);
    public int deleteBook(String isbn);
    public Book getBook(Map<String,String> search);
    public Book updateBook(Book book);    
}
