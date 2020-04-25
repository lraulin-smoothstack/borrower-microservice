package com.smoothstack.lms.borrowerservice.service;

import com.smoothstack.lms.borrowerservice.dao.BookCopyDAO;
import com.smoothstack.lms.borrowerservice.dao.BookDAO;
import com.smoothstack.lms.borrowerservice.dao.BookLoanDAO;
import com.smoothstack.lms.borrowerservice.dao.LibraryBranchDAO;
import com.smoothstack.lms.borrowerservice.entity.*;
import com.smoothstack.lms.borrowerservice.entity.BookCopy.BookCopyId;
import com.smoothstack.lms.borrowerservice.entity.BookLoan.BookLoanId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BorrowerService {
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookLoanDAO bookLoanDAO;

    @Autowired
    private BookCopyDAO bookCopyDAO;

    @Autowired
    private LibraryBranchDAO libraryBranchDAO;

    public List<LibraryBranch> getLibraryBranches() {
        return libraryBranchDAO.findAll();
    }

    public BookLoan checkOutBook(BookLoanId id) {
        Optional<BookCopy> bookCopy = bookCopyDAO.findById(new BookCopyId(id.getBook().getId(), id.getBranch().getId()));
        if (bookCopy.isPresent()) {
            BookCopy bc = bookCopy.get();
            bc.setAmount(bc.getAmount() - 1);
            bookCopyDAO.save(bc);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Book with ID " + id.getBook().getId() + " is not available at branch with ID " + id.getBranch().getId() + ".");
        }

        LocalDate localDate = LocalDate.now();
        int CHECKOUT_DAYS = 7;

        BookLoan bookLoan = new BookLoan();
        bookLoan.setId(id);
        bookLoan.setDateOut(localDate);
        bookLoan.setDueDate(localDate.plusDays(CHECKOUT_DAYS));
        return bookLoanDAO.save(bookLoan);

    }

    public BookLoan checkInBook(BookLoanId id) {
        BookLoan bookLoan = null;
        Optional<BookLoan> maybeBookLoan = bookLoanDAO.findById(id);
        if (maybeBookLoan.isPresent()) {
            bookLoan = maybeBookLoan.get();
            bookLoan.setDateIn(LocalDate.now());

            Optional<BookCopy> maybeBookCopy = bookCopyDAO.findById(new BookCopyId(id.getBook().getId(), id.getBranch().getId()));
            if (maybeBookCopy.isPresent()) {
                BookCopy bookCopy = maybeBookCopy.get();
                bookCopy.setAmount(bookCopy.getAmount() + 1);
                bookCopyDAO.save(bookCopy);
                return bookLoan;
            }
            // else {
            // No record of library having returned book
            // }
        }
        return bookLoan;
    }

    public List<Book> getAvailableBooksNotCheckedOut(long branchId, long borrowerId) {
        List<Long> idsOfBooksCheckedOutByUser = bookLoanDAO.findAll().stream()
                .filter(bl -> bl.getId().getBorrower().getId() == borrowerId).map(bl -> bl.getId().getBorrower().getId())
                .collect(Collectors.toList());
        List<Long> idsOfBooksAvailableAtBranchAndNotCheckedOutByUser = bookCopyDAO.findAll().stream()
                .filter(bc -> bc.getId().getBranch().getId() == branchId).filter(bc -> bc.getAmount() > 0)
                .filter(bc -> !idsOfBooksCheckedOutByUser.contains(bc.getId().getBook().getId()))
                .map(bc -> bc.getId().getBook().getId()).collect(Collectors.toList());
        return bookDAO.findAll().stream()
                .filter(b -> idsOfBooksAvailableAtBranchAndNotCheckedOutByUser.contains(b.getId()))
                .collect(Collectors.toList());
    }

    public List<BookLoan> getBookLoansForBorrower(long branchId, long borrowerId) {
        return bookLoanDAO.findAll().stream()
                .filter(l -> (l.getId().getBorrower().getId() == borrowerId && l.getId().getBranch().getId() == branchId))
                .collect(Collectors.toList());
    }
}