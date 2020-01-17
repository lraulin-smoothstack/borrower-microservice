package com.smoothstack.december.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookLoanId implements Serializable {
    @Column(name = "bookId")
    private Long bookId;

    @Column(name = "branchId")
    private Long branchId;


    @Column(name = "cardNo")
    private Long cardNo;

    public Long getBookId() {
        return bookId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public Long getCardNo() {
        return cardNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookLoanId)) return false;
        BookLoanId that = (BookLoanId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId()) &&
                Objects.equals(getCardNo(), that.getCardNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId(), getCardNo());
    }
}