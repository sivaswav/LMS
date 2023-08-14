package com.librarymanagementsystem;

import com.librarymanagementsystem.books.Book;
import com.librarymanagementsystem.redisCache.AddCache;

public class Main {
    public static void main(String[] args) { 

        AddCache cache=new AddCache();
        Book book = new Book("The Chamber", "Johnny Grisham", "0440220602", "Island Books");
        cache.addData(book);
        String res=cache.getCacheISBN("Johnny Grisham");
        
        System.out.println(res);
    }
}