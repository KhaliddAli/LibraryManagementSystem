package com.example.LibraryManagementSystem.Controller.ResponseClasses;

import com.example.LibraryManagementSystem.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private String name;
    private Genre genre;
    private String author_name;
    private double rating;
    private Integer price;
    private Integer noOfPages;
}
