package com.smoothstack.december.controller;

import java.util.List;

import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/lms/borrower-service")
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/borrowers/{borrowerId}/branches/{branchId}/books/{bookId}:checkout")
    public void checkOutBook(@PathVariable("bookId") long bookId, @PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        borrowerService.checkOutBook(bookId, branchId, borrowerId);
    }

    @PostMapping("/borrowers/{borrowerId}/branches/{branchId}/books/{bookId}:checkin")
    public void checkInBook(@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId,
            @RequestParam("borrowerId") long borrowerId) {
        borrowerService.checkInBook(bookId, branchId, borrowerId);
    }

    @GetMapping("/branches")
    public List<LibraryBranch> getLibraryBranches() {
        return borrowerService.getLibraryBranches();
    }

    @GetMapping("/borrowers/{borrowerId}/branches/{branchId}/available-books/")
    public List<Book> getAvailableBooksNotCheckedOut(@PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        return borrowerService.getAvailableBooksNotCheckedOut(branchId, borrowerId);
    }

    @GetMapping("/branches/{branchId}/borrowers/{borrowerId}")
    public List<BookLoan> getBookLoans(@PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        return borrowerService.getBookLoansForBorrower(branchId, borrowerId);
    }
}
