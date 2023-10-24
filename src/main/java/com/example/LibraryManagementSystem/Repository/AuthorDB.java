package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDB extends JpaRepository<Author,Integer> {
}
