package com.smoothstack.december.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopy {
    @EmbeddedId
    private BookCopyId bookId;

    @Column(name="amount")
    private int amount;

    public int getAmount() {
        return amount;
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
