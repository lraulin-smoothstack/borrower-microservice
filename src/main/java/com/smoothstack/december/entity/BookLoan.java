package com.smoothstack.december.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="tbl_book_loans")
public class BookLoan {
    @EmbeddedId
    private BookLoanId bookId;

    private LocalDate dateOut;
    private LocalDate dateIn;
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
