package com.smoothstack.december.service;

import com.smoothstack.december.dao.BookCopyDAO;
import com.smoothstack.december.dao.BookDAO;
import com.smoothstack.december.dao.BookLoanDAO;
import com.smoothstack.december.dao.LibraryBranchDAO;
import com.smoothstack.december.entity.*;
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
        Optional<BookCopy> bookCopy = bookCopyDAO.findById(new BookCopyId(id.getBookId(), id.getBranchId()));
        if (bookCopy.isPresent()) {
            BookCopy bc = bookCopy.get();
            bc.setAmount(bc.getAmount() - 1);
            bookCopyDAO.save(bc);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Book with ID " + id.getBookId() + " is not available at branch with ID " + id.getBranchId() + ".");
        }

        LocalDate localDate = LocalDate.now();
        int CHECKOUT_DAYS = 7;

        BookLoan bookLoan = new BookLoan();
        bookLoan.setBookId(id);
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

            Optional<BookCopy> maybeBookCopy = bookCopyDAO.findById(new BookCopyId(id.getBookId(), id.getBranchId()));
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
                .filter(bl -> bl.getId().getBorrowerId() == borrowerId).map(bl -> bl.getId().getBorrowerId())
                .collect(Collectors.toList());
        List<Long> idsOfBooksAvailableAtBranchAndNotCheckedOutByUser = bookCopyDAO.findAll().stream()
                .filter(bc -> bc.getId().getBranchId() == branchId).filter(bc -> bc.getAmount() > 0)
                .filter(bc -> !idsOfBooksCheckedOutByUser.contains(bc.getId().getBookId()))
                .map(bc -> bc.getId().getBookId()).collect(Collectors.toList());
        return bookDAO.findAll().stream()
                .filter(b -> idsOfBooksAvailableAtBranchAndNotCheckedOutByUser.contains(b.getId()))
                .collect(Collectors.toList());
    }

    public List<BookLoan> getBookLoansForBorrower(long branchId, long borrowerId) {
        return bookLoanDAO.findAll().stream()
                .filter(l -> (l.getId().getBorrowerId() == borrowerId && l.getId().getBranchId() == branchId))
                .collect(Collectors.toList());
    }
}