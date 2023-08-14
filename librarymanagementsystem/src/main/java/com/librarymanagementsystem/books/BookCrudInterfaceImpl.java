package com.librarymanagementsystem.books;

import java.sql.*;
import java.util.Map;

import com.librarymanagementsystem.dao.BookDao;

public class BookCrudInterfaceImpl implements BookCrudInterface { 
    private Connection con;

    @Override
    public int addBook(Book book) throws SQLException {
        int result=0;
        try {
            con = BookDao.getConnection();
            String sql = "insert into Books values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublication());
            result=ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            con.rollback();
            System.out.println(getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            con.commit();
            
        }
        return result;
    }

    @Override
    public int deleteBook(String isbn) throws SQLException {
        int result=0;
         try {
            con = BookDao.getConnection();
            String sql = "delete from Books where isbn=?";
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setString(1, isbn);
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            con.rollback();
            System.out.println(getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            con.commit();
            
        }
        return result;
    }

    @Override
    public Book getBook(Map<String, String> search) throws SQLException { 
         Book book=null;
        try{
            con = BookDao.getConnection();           
            String sql = "select * from Books where ";
            PreparedStatement ps=null;
        for(String key:search.keySet()){
            if(key.equals("isbn") ){
                sql+=" isbn=?";
                  ps = con.prepareStatement(sql); 
            ps.setString(1, search.get(key));
            

        }else if(key.equals("title")){
                  sql+=" title=?";
                  ps = con.prepareStatement(sql); 
            ps.setString(1, search.get(key)); 
        }else{
              sql+=" author=?";
                  ps = con.prepareStatement(sql); 
            ps.setString(1, search.get(key)); 
        }
        }
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            book=new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
        }
    }catch (Exception e) {
            con.rollback();
            System.out.println(getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            con.commit();
            
        }
        return book;
        
    }

    @Override
    public Book updateBook(Book book) throws SQLException { 
         try {
            con = BookDao.getConnection();
            String sql = "update Books where set title=?,author=? where isbn=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getIsbn());
            ps.executeUpdate();
            ps.close();
            
        } catch (Exception e) {
            con.rollback();
            System.out.println(getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            con.commit();
            
        }
        return book;
        
    }

}
