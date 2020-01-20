package com.smoothstack.december.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smoothstack.december.dao.BookCopyDAO;
import com.smoothstack.december.dao.BookDAO;
import com.smoothstack.december.dao.BookLoanDAO;

import com.smoothstack.december.dao.LibraryBranchDAO;
import com.smoothstack.december.entity.BookCopy;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.BookLoanId;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lms/borrower")
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @PutMapping("/bookloans")
    public void checkoutBook(@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId,
            @RequestParam("borrowerId") long borrowerId) {
        borrowerService.checkoutBook(bookId, branchId, borrowerId);
    }

    // @PostMapping("/bookloans")
    // public void checkinBook(@RequestParam("bookId") int bookId,
    // @RequestParam("branchId") int branchId,
    // @RequestParam("cardNumber") int cardNumber) {
    // System.out.println("");
    // }

    @GetMapping("/branches")
    public List<LibraryBranch> getLibraryBranches() {
        return borrowerService.getLibraryBranches();
    }

    // @GetMapping("/branchbooks/{:branchId}")
    // public List<Book> getAvailableBooks(@PathVariable("branchId") int branchId,
    // @RequestParam("cardNumber") int cardNumber) {
    // try {
    // return bookDAO.getAvailableBooksNotCheckedOut(branchId, cardNumber);
    // } catch (SQLException e) {
    // System.out.println(e);
    // }
    // return null;
    // }
    //
    // @GetMapping("/bookloans/{:branchId}")
    // public List<BookLoan> getBookLoans(@PathVariable("branchId") int branchId,
    // @RequestParam("cardNumber") int cardNumber) {
    // try {
    // return bookLoanDAO.getBookLoansForBorrower(branchId, cardNo);
    // } catch (SQLException | ClassNotFoundException e) {
    // System.out.println(e);
    // }
    // return null;
    // }
}
