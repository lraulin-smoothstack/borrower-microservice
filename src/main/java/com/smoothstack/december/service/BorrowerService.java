package com.smoothstack.december.service;

import com.smoothstack.december.dao.BookCopyDAO;
import com.smoothstack.december.dao.BookDAO;
import com.smoothstack.december.dao.BookLoanDAO;
import com.smoothstack.december.dao.LibraryBranchDAO;
import com.smoothstack.december.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void checkOutBook(long bookId, long branchId, long borrowerId) {
        LocalDate localDate = LocalDate.now();
        int CHECKOUT_DAYS = 7;

        BookLoan bookLoan = new BookLoan();
        bookLoan.setBookId(new BookLoanId(bookId, borrowerId, branchId));
        bookLoan.setDateOut(localDate);
        bookLoan.setDueDate(localDate.plusDays(CHECKOUT_DAYS));
        bookLoanDAO.save(bookLoan);

        Optional<BookCopy> bookCopy = bookCopyDAO.findById(new BookCopyId(bookId, branchId));
        if (bookCopy.isPresent()) {
            BookCopy bc = bookCopy.get();
            bc.setAmount(bc.getAmount() - 1);
            bookCopyDAO.save(bc);
        }
        // else {
        // No copies are available
        // TODO: Handle error properly
        // }
    }

    public void checkInBook(long bookId, long branchId, long borrowerId) {
        Optional<BookLoan> maybeBookLoan = bookLoanDAO.findById(new BookLoanId(bookId, borrowerId, branchId));
        if (maybeBookLoan.isPresent()) {
            BookLoan bookLoan = maybeBookLoan.get();
            bookLoan.setDateIn(LocalDate.now());

            Optional<BookCopy> maybeBookCopy = bookCopyDAO.findById(new BookCopyId(bookId, branchId));
            if (maybeBookCopy.isPresent()) {
                BookCopy bookCopy = maybeBookCopy.get();
                bookCopy.setAmount(bookCopy.getAmount() + 1);
                bookCopyDAO.save(bookCopy);
            }
            // else {
            // No record of library having returned book
            // TODO: Handle error properly
            // }
        }
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
        return bookLoanDAO.findAll().stream().filter(l->(l.getId().getBorrowerId()==borrowerId && l.getId().getBranchId()==branchId)).collect(Collectors.toList());
    }
}