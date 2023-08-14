package com.librarymanagementsystem.bookreservation;

import java.sql.SQLException;

import com.librarymanagementsystem.dao.BookReservationDao;

public class ReservationInterfaceImpl implements ReservationInterface {

    private BookReservationDao br;

    public ReservationInterfaceImpl() {
        br = new BookReservationDao();
    }

    @Override
    public BookReservation reserveBook(BookReservation bookReservation) throws SQLException {
        br.addreservation(bookReservation);
        return br.getreservation(bookReservation.getBookingID());
    }

    @Override
    public BookReservation releaseReservation(BookReservation bookReservation) throws SQLException {
        br.closereservation(bookReservation.getBookingID());
        return br.getreservation(bookReservation.getBookingID());
    }

}
