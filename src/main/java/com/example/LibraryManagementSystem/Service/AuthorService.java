package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.Author;
import com.example.LibraryManagementSystem.Repository.AuthorDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorDB authorDB;

    public void addAuthor(Author author) {

        authorDB.save(author);
    }

    public List<String> getAllAuthors() {
        List<Author> authors = authorDB.findAll();
        List<String> authorNamelist = new ArrayList<>();
        for(Author author : authors){
            authorNamelist.add(author.getName());
        }

        return authorNamelist;
    }

    public Optional<Author> getAuthor(Integer auhtorID) {
        return authorDB.findById(auhtorID);
    }
}
