package com.librarymanagementsystem.books;

import java.util.HashMap;
import java.util.Map;


public class BookOperationsInterfaceImpl implements BookOperationsInterface {

    private BookCrudInterface bookCrudInterface=new BookCrudInterfaceImpl() ; 

    @Override
    public Book searchBookByAuthor(String author) {
        Map<String,String> search=new HashMap<>();
        search.put("author", author);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book searchBookByTitle(String title) {
        Map<String,String> search=new HashMap<>();
        search.put("title", title);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book searchBookByisbn(String isbn) {
        Map<String,String> search=new HashMap<>();
        search.put("isbn", isbn);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public Book insertBook(Book book) {
        Map<String,String> search=new HashMap<>();
        search.put("isbn", book.getIsbn());
        bookCrudInterface.addBook(book);
        return bookCrudInterface.getBook(search);
    }

    @Override
    public int deleteBook(String isbn) {
        return bookCrudInterface.deleteBook(isbn);
    }

    @Override
    public Book updateBook(Book book) {
        return updateBook(book); 
        
    }


     
    
}
