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
import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookCopy;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.BookLoanId;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/borrower")
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/checkout")
    public void checkOutBook(@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId,
            @RequestParam("borrowerId") long borrowerId) {
        borrowerService.checkOutBook(bookId, branchId, borrowerId);
    }

    @PostMapping("/checkin")
    public void checkInBook(@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId,
            @RequestParam("borrowerId") long borrowerId) {
        borrowerService.checkInBook(bookId, branchId, borrowerId);
    }

    @GetMapping("/library-branches")
    public List<LibraryBranch> getLibraryBranches() {
        return borrowerService.getLibraryBranches();
    }

    @GetMapping("/branch-{:branchId}")
    public List<Book> getAvailableBooksNotCheckedOut(@PathVariable("branchId") long branchId,
            @RequestParam("borrowerId") long borrowerId) {
        try {
            return borrowerService.getAvailableBooksNotCheckedOut(branchId, borrowerId);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
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
