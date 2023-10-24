package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Controller.ResponseClasses.BookResponse;
import com.example.LibraryManagementSystem.Entity.Book;
import com.example.LibraryManagementSystem.Enums.Genre;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity addBook(@RequestBody Book book , @RequestParam("authorID") Integer authorID){
        try{
            bookService.addBook(book, authorID);
            return new ResponseEntity<>("Book Added SuccessFully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
        }
    }

    @GetMapping("/get-book-by-genre")
    public List<String> getBookByGenre(@RequestParam("genre") Genre genre){
        return bookService.getBooksOfGenre(genre);
    }

    @GetMapping("/getBook")
    public BookResponse getBook(@RequestParam("bookName") String bookName) {
        Book book = bookService.getBookByName(bookName);
        return new BookResponse(book.getBookName() , book.getGenre() ,
                book.getAuthor().getName(), book.getRating() ,
                book.getPrice() , book.getNoOfPages()) ;
    }
}
