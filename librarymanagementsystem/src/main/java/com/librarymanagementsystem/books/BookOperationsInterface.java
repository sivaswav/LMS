package com.librarymanagementsystem.books;

public interface BookOperationsInterface {
    public Book searchBookByAuthor(String author);

    public Book searchBookByTitle(String title);

    public Book searchBookByisbn(String isbn);
}
