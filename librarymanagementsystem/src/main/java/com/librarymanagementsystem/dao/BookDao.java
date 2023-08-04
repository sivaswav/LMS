package com.librarymanagementsystem.dao;
import java.sql.*;

public class BookDao {
    private static Connection con; 
    static{
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:book.db");
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
         }
         System.out.println("Opened database successfully");
    }
    public static Connection getConnection(){
            return con;
    }

}
