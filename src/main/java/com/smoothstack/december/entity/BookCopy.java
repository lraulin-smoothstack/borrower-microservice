package com.smoothstack.december.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopy {
    @EmbeddedId
    private BookCopyId bookId;

    @Column(name = "branchId")
    private int branchId;

    @Column(name="amount")
    private int amount;

    public int getBranchId() {
        return branchId;
    }

    public int getAmount() {
        return amount;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BookCopyId getBookId() {
        return bookId;
    }

    public void setBookId(BookCopyId bookId) {
        this.bookId = bookId;
    }
}
