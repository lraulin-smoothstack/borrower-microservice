package com.smoothstack.december.controller;

import java.util.List;
import java.util.Map;

import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;

    // QUESTION: post or put? path or query?
    @RequestMapping(path = "/lms/borrower/bookloans", method = RequestMethod.POST)
    public Map<String, Object> checkoutBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.checkoutBook(bookId, branchId, cardNumber);
    }

    @RequestMapping(path = "/lms/borrower/bookloans", method = RequestMethod.PUT)
    public void checkinBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        borrowerService.checkinBook(bookId, branchId, cardNumber);

    }

    @RequestMapping(path = "/lms/borrower/branches", method = RequestMethod.GET)
    public List<LibraryBranch> getLibraryBranches() {
        return borrowerService.getLibraryBranches();
    }

    @RequestMapping(path = "/lms/borrower/branchbooks/{:branchId}", method = RequestMethod.GET)
    public List<Book> getAvailableBooks(@PathVariable("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.getAvailableBooksNotCheckedOut(cardNumber, branchId);
    }

    @RequestMapping(path = "/lms/borrower/bookloans/{:branchId}", method = RequestMethod.GET)
    public List<BookLoan> getBookLoans(@PathVariable("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.getBookLoans(cardNumber, branchId);
    }
}
