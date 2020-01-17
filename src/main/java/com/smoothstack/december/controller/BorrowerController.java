package com.smoothstack.december.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.smoothstack.december.dao.BookCopyDAO;
import com.smoothstack.december.dao.BookDAO;
import com.smoothstack.december.dao.BookLoanDAO;

import com.smoothstack.december.dao.LibraryBranchDAO;
import com.smoothstack.december.entity.BookCopy;
import com.smoothstack.december.entity.LibraryBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lms/borrower")
public class BorrowerController {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookLoanDAO bookLoanDAO;

    @Autowired
    private BookCopyDAO bookCopyDAO;

    @Autowired
    private LibraryBranchDAO libraryBranchDAO;

//    @GetMapping("/bookloans")
//    public Map<String, Object> checkoutBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
//            @RequestParam("cardNumber") int cardNumber) {
//        try {
//            BookCopy branchsBook = bookCopyDAO.findAll();
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    @PutMapping("/bookloans")
//    public void checkinBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
//            @RequestParam("cardNumber") int cardNumber) {
//        try {
//            bookLoanDAO.checkinBook(bookId, branchId, cardNumber);
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//    }

    @GetMapping("/branches")
    public List<LibraryBranch> getLibraryBranches() {
        return libraryBranchDAO.findAll();
    }

//    @GetMapping("/branchbooks/{:branchId}")
//    public List<Book> getAvailableBooks(@PathVariable("branchId") int branchId,
//            @RequestParam("cardNumber") int cardNumber) {
//        try {
//            return bookDAO.getAvailableBooksNotCheckedOut(branchId, cardNumber);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
//
//    @GetMapping("/bookloans/{:branchId}")
//    public List<BookLoan> getBookLoans(@PathVariable("branchId") int branchId,
//            @RequestParam("cardNumber") int cardNumber) {
//        try {
//            return bookLoanDAO.getBookLoansForBorrower(branchId, cardNo);
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
//        return null;
//    }
}
