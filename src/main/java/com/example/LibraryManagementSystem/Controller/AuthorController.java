package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Controller.ResponseClasses.AuthorResponse;
import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestBody Author author) {
        try{
            authorService.addAuthor(author);
            return new ResponseEntity<>("Author successfully added", HttpStatus.OK);
        }
        catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage() , HttpStatus.OK);
        }
    }

    @GetMapping("/find-All-Authors")
    public List<String> findAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/getAuthor")
    public ResponseEntity getAuthor(@RequestParam("authorID") Integer auhtorID) {
        Optional<Author> optionalAuthor = authorService.getAuthor(auhtorID);

        if(optionalAuthor.isEmpty()) {
            return new ResponseEntity<>("Author not found" , HttpStatus.OK);
        }

        Author author = optionalAuthor.get();

        AuthorResponse response = new AuthorResponse(author.getName(),author.getAge(),author.getRating());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}

