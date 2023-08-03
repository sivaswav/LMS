package com.librarymanagementsystem.books;

public interface BookCrudInterface {
    public void addBook(Book book);
    public void deleteBook(Book book);
    public Book getBook(String isbn);
    public Book updateBook(Book book);    
}
