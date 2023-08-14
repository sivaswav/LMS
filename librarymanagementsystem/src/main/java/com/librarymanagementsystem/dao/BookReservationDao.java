package com.librarymanagementsystem.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.librarymanagementsystem.bookreservation.BookReservation;

import javafx.scene.input.DataFormat;

public class BookReservationDao {
    private static Connection conn;
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:book.db");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public BookReservation addreservation(BookReservation bookreservation) throws SQLException {
        PreparedStatement stmt;
        String str = "insert into bookrervation values (?,?,?,?,?,?,?,?)";
        stmt = conn.prepareStatement(str);
        stmt.setString(1, bookreservation.getBookingID());
        stmt.setString(2, bookreservation.getUserID());
        stmt.setString(3, bookreservation.getContactNo());
        stmt.setString(4, bookreservation.getBookingDate());
        stmt.setString(5, bookreservation.getLibrarianID());
        stmt.setString(6, bookreservation.getDueDate());
        stmt.setString(7, String.valueOf(bookreservation.getIsApproved()));
        stmt.setString(8, bookreservation.getIsbn());
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        return bookreservation;
    }

    public int closereservation(String bookingID) throws SQLException {
        PreparedStatement stmt;
        LocalDate ld = LocalDate.now();
        SimpleDateFormat sd = new SimpleDateFormat("DD/MM/YYYY");

        String str = "update bookrervation set closed_dt=? where booking_id=? ";
        stmt = conn.prepareStatement(str);
        stmt.setString(1, sd.format(ld));
        stmt.setString(2, bookingID);
        int res = stmt.executeUpdate();
        stmt.close();
        conn.commit();
        return res;
    }

    public BookReservation getreservation(String bookingID) throws SQLException {
        PreparedStatement stmt;
        BookReservation br = null;
        LocalDate ld = LocalDate.now();
        SimpleDateFormat sd = new SimpleDateFormat("DD/MM/YYYY");

        String str = "select * from bookrervation where booking_id=? ";
        stmt = conn.prepareStatement(str);
        stmt.setString(1, bookingID);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            br = new BookReservation(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), Boolean.valueOf(res.getString(7)), res.getString(8));
        }
        stmt.close();
        conn.commit();
        return br;
    }
}
