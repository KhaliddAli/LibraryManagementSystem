package com.example.LibraryManagementSystem.Entity;

import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.*;

@Entity
@Table(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;

    private String bookName;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer price;

    private Integer noOfPages;

    private Double rating;

    private boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    List<Transactions> listOfTransaction = new ArrayList<>();
}
