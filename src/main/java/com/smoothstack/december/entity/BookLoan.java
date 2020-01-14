package com.smoothstack.december.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookLoan {
    private int bookId;
    private int branchId;
    private int cardNumber;
    private Date dateOut;
    private Date dateIn;

    public BookLoan() {
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
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

    public BookLoan(int bookId, int branchId, int cardNumber, Date dateOut, Date dateIn) {
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
        try {

            this.setDateOut(new SimpleDateFormat("dd/MM/yyyy").parse(dateOut));
            this.setDateIn(new SimpleDateFormat("dd/MM/yyyy").parse(dateIn));
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

}
