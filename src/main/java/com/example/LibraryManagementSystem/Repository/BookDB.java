package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDB extends JpaRepository<Book, Integer> {

    List<Book> findBooksByGenre(Genre genre);

    Book findBookByBookName(String bookName);
}
