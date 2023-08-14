package com.librarymanagementsystem.bookreservation;

import java.sql.SQLException;

public interface ReservationInterface {   
    public BookReservation reserveBook(BookReservation bookReservation) throws SQLException;
     public BookReservation releaseReservation(BookReservation bookReservation) throws SQLException;
}
