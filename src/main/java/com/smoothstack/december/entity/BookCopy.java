package com.smoothstack.december.entity;

public class BookCopy {
    public BookCopy() {
    }

    public BookCopy(int bookId, int branchId, int amount) {
        this.bookId = bookId;
        this.branchId = branchId;
        this.amount = amount;
    }

    private int bookId;
    private int branchId;
    private int amount;

    public int getBookId() {
        return bookId;
    }

    public int getBranchId() {
        return branchId;
    }

    public int getAmount() {
        return amount;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
