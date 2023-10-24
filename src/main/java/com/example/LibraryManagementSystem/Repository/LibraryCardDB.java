package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardDB extends JpaRepository<LibraryCard,Integer> {
}
