package com.smoothstack.december.controller;

import java.util.List;

import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
        return borrowerService.getAvailableBooksNotCheckedOut(branchId, borrowerId);
    }

    @GetMapping("/branch-{:branchId}/borrower-{:borrowerId}")
    public List<BookLoan> getBookLoans(@PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        return borrowerService.getBookLoansForBorrower(branchId, borrowerId);
    }
}
