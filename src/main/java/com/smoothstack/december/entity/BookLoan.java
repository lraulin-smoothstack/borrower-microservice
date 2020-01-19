package com.smoothstack.december.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class BookLoan {
    @EmbeddedId
    private BookLoanId bookId;

    @Column
    private LocalDate dateOut;

    @Column
    private LocalDate dateIn;

    @Column
    private LocalDate dueDate;

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

    public BookLoanId getBookId() {
        return bookId;
    }

    public void setBookId(BookLoanId bookId) {
        this.bookId = bookId;
    }
}
