package com.librarymanagementsystem.books;

public class Book {
    private String title,author,isbn,publication;
    

    public Book(String title, String author, String isbn, String publication) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication = publication;
    }

    public Book(String title, String author, String isbn){
        this(title,author,isbn,null);
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    
}
