package com.smoothstack.december.controller;

import java.util.List;

import javax.validation.Valid;

import com.smoothstack.december.entity.Book;
import com.smoothstack.december.entity.BookLoan;
import com.smoothstack.december.entity.BookLoanId;
import com.smoothstack.december.entity.LibraryBranch;
import com.smoothstack.december.exception.ArgumentMissingException;
import com.smoothstack.december.exception.IllegalRelationReferenceException;
import com.smoothstack.december.service.BorrowerService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("v1/lms/borrower-service")
public class BorrowerController {
    private static final Logger logger = LogManager.getLogger(BorrowerController.class);

    @Autowired
    BorrowerService borrowerService;

    @PostMapping("/borrowers/{borrowerId}/branches/{branchId}/books/{bookId}:checkout")
    public ResponseEntity<BookLoan> checkOutBook(@RequestBody @Valid BookLoanId id) {
        BookLoan response = null;
        try {
            logger.debug("request: {}", id.toString());
            response = borrowerService.checkOutBook(id);
            logger.debug("response: {}", response.toString());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage());
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception exception) {
            logger.error(exception.toString());
        }
        return new ResponseEntity<BookLoan>(response, HttpStatus.OK);
    }

    @PostMapping("/borrowers/{borrowerId}/branches/{branchId}/books/{bookId}:checkin")
    public ResponseEntity<BookLoan> checkInBook(@RequestBody @Valid BookLoanId id) {
        BookLoan response = null;
        try {
            logger.debug("request: {}", id.toString());
            response = borrowerService.checkInBook(id);
            logger.debug("response: {}", response.toString());
        } catch (ArgumentMissingException argumentMissingException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, argumentMissingException.getMessage());
        } catch (IllegalRelationReferenceException illegalRelationReferenceException) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception exception) {
            logger.error(exception.toString());
        }
        return new ResponseEntity<BookLoan>(response, HttpStatus.OK);
    }

    @GetMapping("/branches")
    public ResponseEntity<List<LibraryBranch>> getLibraryBranches() {
        List<LibraryBranch> response = null;
        try {
            response = borrowerService.getLibraryBranches();
            logger.debug("response: {}", response.toString());
        } catch (Exception exception) {
            logger.error(exception.toString());
        }

        return new ResponseEntity<List<LibraryBranch>>(response, HttpStatus.OK);
    }

    @GetMapping("/borrowers/{borrowerId}/branches/{branchId}/available-books/")
    public ResponseEntity<List<Book>> getAvailableBooksNotCheckedOut(@PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        List<Book> response = null;

        try {
            logger.debug("request: {}", branchId);
            response = borrowerService.getAvailableBooksNotCheckedOut(branchId, borrowerId);
            logger.debug("response: {}", response.toString());
        } catch (IllegalRelationReferenceException irre) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, irre.getMessage(), irre);
        } catch (Exception exception) {
            logger.error(exception.toString());
        }

        return new ResponseEntity<List<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/branches/{branchId}/borrowers/{borrowerId}")
    public ResponseEntity<List<BookLoan>> getBookLoans(@PathVariable("branchId") long branchId,
            @PathVariable("borrowerId") long borrowerId) {
        List<BookLoan> response = null;

        try {
            logger.debug("request: {}", branchId);
            response = borrowerService.getBookLoansForBorrower(branchId, borrowerId);
            logger.debug("response: {}", response.toString());
        } catch (IllegalRelationReferenceException irre) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, irre.getMessage(), irre);
        } catch (Exception exception) {
            logger.error(exception.toString());
        }

        return new ResponseEntity<List<BookLoan>>(response, HttpStatus.OK);
    }
}
