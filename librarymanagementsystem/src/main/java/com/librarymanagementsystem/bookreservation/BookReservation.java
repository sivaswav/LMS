package com.librarymanagementsystem.bookreservation;

import com.librarymanagementsystem.books.Book;

public class BookReservation {
    private String bookingID,userID,contactNo,bookingDate,librarianID,dueDate;
    private Boolean isApproved;
    private Book book;
    public BookReservation(String bookingID, String userID, String contactNo, String bookingDate, String librarianID,
            String dueDate, Boolean isApproved, Book book) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.contactNo = contactNo;
        this.bookingDate = bookingDate;
        this.librarianID = librarianID;
        this.dueDate = dueDate;
        this.isApproved = isApproved;
        this.book = book;
    }
    public String getBookingID() {
        return bookingID;
    }
    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    public String getLibrarianID() {
        return librarianID;
    }
    public void setLibrarianID(String librarianID) {
        this.librarianID = librarianID;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    public Boolean getIsApproved() {
        return isApproved;
    }
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    
}
