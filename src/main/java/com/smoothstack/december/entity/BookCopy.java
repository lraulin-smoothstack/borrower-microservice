package com.smoothstack.december.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_book_copies")
public class BookCopy {
    @EmbeddedId
    private BookCopyId bookId;

    @Column(name = "amount")
    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BookCopyId getBookId() {
        return bookId;
    }

    public void setBookId(BookCopyId bookId) {
        this.bookId = bookId;
    }
}
