package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.LibraryCard;
import com.example.LibraryManagementSystem.Entity.Transactions;
import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import com.example.LibraryManagementSystem.Repository.BookDB;
import com.example.LibraryManagementSystem.Repository.LibraryCardDB;
import com.example.LibraryManagementSystem.Repository.TransactionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionDB transactionDB;
    @Autowired
    BookDB bookDB;
    @Autowired
    LibraryCardDB libraryCardDB;

    private Integer FinePerDay = 10;

    public Object issueBook(Integer bookId, Integer cardId) throws Exception {
        Transactions newTransaction = new Transactions();
        Optional<Book> optionalBook = bookDB.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Enter valid book ID");
        }
        Book book = optionalBook.get();
        //checking if the book is available
        if(!book.isAvailable()) throw new Exception("Book not available");

        Optional<LibraryCard> optionalLibraryCard = libraryCardDB.findById(cardId);
        if(optionalLibraryCard.isEmpty() || (!optionalLibraryCard.get().getCardStatus().equals(Status.ACTIVE))){
            throw new Exception("Enter valid Library Card ID");
        }
        LibraryCard libraryCard = optionalLibraryCard.get();

        newTransaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        newTransaction.setIssueDate(new Date());

        //adding book
        newTransaction.setBook(book);
        book.getListOfTransaction().add(newTransaction);

        //adding card details
        newTransaction.setLibraryCard(libraryCard);
        libraryCard.getTransactionOfBook().add(newTransaction);

        book.setAvailable(false);


        transactionDB.save(newTransaction);

        return "Book Issue Successfully !";
    }


    public Object returnBook(Integer bookId, Integer cardId) {
        Book book = bookDB.findById(bookId).get();
        LibraryCard libraryCard = libraryCardDB.findById(cardId).get();

        Transactions issueTransaction = transactionDB.findTransactionsByBookAndLibraryCardAndTransactionStatus(book,libraryCard,TransactionStatus.SUCCESSFUL);

        Date issuedate = issueTransaction.getTransactionDate() ;

        long time = Math.abs(System.currentTimeMillis()-issuedate.getTime());
        Long days = TimeUnit.DAYS.convert(time , TimeUnit.MILLISECONDS);

        int fineAmount =0;

        if(days>7){
            fineAmount = Math.toIntExact((days-7) * FinePerDay);
        }
        Transactions transaction = new Transactions();

        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        transaction.setReturnDate(new Date());

        //setting FK
        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);

        //setting for fk's
        book.getListOfTransaction().add(transaction);
        libraryCard.getTransactionOfBook().add(transaction);

        transactionDB.save(transaction);

        return "Book return Successfully , Fine for this return is " + fineAmount;
    }
}
