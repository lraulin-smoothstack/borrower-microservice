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

    public void checkoutBook(long bookId, long branchId, long borrowerId) {
        LocalDate localDate = LocalDate.now();
        int CHECKOUT_DAYS = 7;

        BookLoanId id = new BookLoanId();
        id.setBookId(bookId);
        id.setBorrowerId(borrowerId);
        id.setBranchId(branchId);

        BookLoan bookLoan = new BookLoan();
        bookLoan.setBookId(id);
        bookLoan.setDateOut(localDate);
        bookLoan.setDueDate(localDate.plusDays(CHECKOUT_DAYS));

        bookLoanDAO.save(bookLoan);

        BookCopyId bookCopyId = new BookCopyId(bookId, branchId);
        Optional<BookCopy> bookCopy = bookCopyDAO.findById(bookCopyId);
        if (bookCopy.isPresent()) {
            BookCopy bc = bookCopy.get();
            bc.setAmount(bc.getAmount() - 1);
        }
    }
}