package com.smoothstack.december.controller;

import java.util.List;
import java.util.Map;

import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;

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
    BorrowerService borrowerService; // inject dependency

    // QUESTION: post or put? path or query?
    @GetMapping("/bookloans")
    public Map<String, Object> checkoutBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.checkoutBook(bookId, branchId, cardNumber);
    }

    @PutMapping("/bookloans")
    public void checkinBook(@RequestParam("bookId") int bookId, @RequestParam("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        borrowerService.checkinBook(bookId, branchId, cardNumber);
    }

    @GetMapping("/branches")
    public List<LibraryBranch> getLibraryBranches() {
        return borrowerService.getLibraryBranches();
    }

    @GetMapping("/branchbooks/{:branchId}")
    public List<Book> getAvailableBooks(@PathVariable("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.getAvailableBooksNotCheckedOut(cardNumber, branchId);
    }

    @GetMapping("/bookloans/{:branchId}")
    public List<BookLoan> getBookLoans(@PathVariable("branchId") int branchId,
            @RequestParam("cardNumber") int cardNumber) {
        return borrowerService.getBookLoans(cardNumber, branchId);
    }
}
