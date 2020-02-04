# Library Management System
## Borrower Service

Spring Boot microservice. Provides Library Management System functionality for a library user via REST API.

Check a book out:
`POST /borrower/borrowers/:borrowerId/branches/:branchId/books/:bookId:checkout`

Check a book in:
`POST /borrower/borrowers/:borrowerId/branches/:branchId/books/:bookId:checkin`

Get all library branches:
`GET /borrower/branches`

Get all books that are available at a branch and that are not currently checkout out by user:
`GET /borrowers/:borrowerId/branches/:branchId/available-books/`

Get all books the user has borrowed and not yet returned:
`GET /branches/:branchId/borrowers/:borrowerId`