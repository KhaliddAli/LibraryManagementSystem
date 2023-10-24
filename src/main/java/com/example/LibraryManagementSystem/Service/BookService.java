package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Enums.Genre;
import com.example.LibraryManagementSystem.Repository.AuthorDB;
import com.example.LibraryManagementSystem.Repository.BookDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookDB bookDB;
    @Autowired
    AuthorDB authorDB;

    public void addBook(Book book , Integer authorID) throws Exception {
        Optional<Author> optionalAuthor = authorDB.findById(authorID);

        if(optionalAuthor.isEmpty()){
            throw new Exception("Author not Found !") ;
        }
        Author author = optionalAuthor.get();

        book.setAuthor(author);

        author.getListOfBooks().add(book);

        bookDB.save(book);
    }

    public List<String> getBooksOfGenre(Genre genre) {
        List<String> bookNames = new ArrayList<>();

        List<Book> booksByGenre = bookDB.findBooksByGenre(genre);
        for(Book book : booksByGenre){
            bookNames.add(book.getBookName());
        }

        return bookNames;
    }

    public Book getBookByName(String name){
        return bookDB.findBookByBookName(name);
    }
}
