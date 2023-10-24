package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Entity.LibraryCard;
import com.example.LibraryManagementSystem.Entity.Transactions;
import com.example.LibraryManagementSystem.Enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDB extends JpaRepository<Transactions , Integer> {
    Transactions findTransactionsByBookAndLibraryCardAndTransactionStatus(Book book , LibraryCard libraryCard , TransactionStatus transactionStatus);
}
