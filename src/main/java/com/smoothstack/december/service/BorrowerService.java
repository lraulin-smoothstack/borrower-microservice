package com.smoothstack.december.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.december.dao.BookDAO;
import com.smoothstack.december.dao.BookLoanDAO;
import com.smoothstack.december.dao.LibraryBranchDAO;
import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.LibraryBranch;

@Service
public class BorrowerService {

    @Autowired
    BookDAO bookDAO;

    @Autowired
    BookLoanDAO bookLoanDAO;

    @Autowired
    LibraryBranchDAO libraryBranchDAO;

    public Map<String, Object> checkoutBook(int bookId, int branchId, int cardNumber) {
        try {
            return bookLoanDAO.checkoutBook(bookId, branchId, cardNumber);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public void checkinBook(int bookId, int branchId, int cardNumber) {
        try {
            bookLoanDAO.checkinBook(bookId, branchId, cardNumber);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<LibraryBranch> getLibraryBranches() {
        try {
            return libraryBranchDAO.getBranchs();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Book> getAvailableBooksNotCheckedOut(int cardNumber, int libraryBranchId) {
        try {
            return bookDAO.getAvailableBooksNotCheckedOut(libraryBranchId, cardNumber);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<BookLoan> getBookLoans(int branchId, int cardNo) {
        try {
            return bookLoanDAO.getBookLoansForBorrower(branchId, cardNo);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }

}
