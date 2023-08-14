package com.librarymanagementsystem.redisCache;

import com.librarymanagementsystem.books.Book;

import redis.clients.jedis.Jedis;

public class AddCache {
    private Jedis jd = CacheDao.getJedisConn();

    public void addData(Book book){ 
         jd.set(book.getIsbn(), book.toString());
         
        jd.expire(book.getIsbn(), 100);
         jd.set(book.getAuthor(), book.toString());
         
        jd.expire(book.getAuthor(), 100);
         jd.set(book.getTitle(), book.toString());
         
        jd.expire(book.getTitle(), 100);
    }

    public String getCacheISBN(String isbn) {
        return jd.get(isbn);
    }

    public String getCacheAuthor(String author) {
        return jd.get(author);
    }

    public String getCacheTitle(String title) {
        return jd.get(title);
    }

}
