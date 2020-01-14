package com.smoothstack.december.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookLoan {
    private int bookId;
    private int branchId;
    private int cardNumber;
    private LocalDate dateOut;
    private LocalDate dateIn;
    private LocalDate dueDate;

    public BookLoan() {
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BookLoan(int bookId, int branchId, int cardNumber, LocalDate dateOut, LocalDate dateIn) {
        this.setBookId(bookId);
        this.setBranchId(branchId);
        this.setCardNumber(cardNumber);
        this.setDateOut(dateOut);
        this.setDateIn(dateIn);
    }

    public BookLoan(int bookId, int branchId, int cardNumber, String dateOut, String dateIn) {
        this.setBookId(bookId);
        this.setBranchId(branchId);
        this.setCardNumber(cardNumber);

        this.setDateOut(LocalDate.parse(dateOut, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.setDateIn(LocalDate.parse(dateOut, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

}
