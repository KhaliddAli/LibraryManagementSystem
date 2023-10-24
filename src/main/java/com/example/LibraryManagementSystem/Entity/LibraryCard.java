package com.example.LibraryManagementSystem.Entity;

import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Service.LibraryCardService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LibraryCard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;

    @Enumerated(value = EnumType.STRING)
    private Status cardStatus;

    private String nameOnCard;

    private Integer noOfBooksIssued;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Student student;

    @OneToMany(mappedBy = "libraryCard", cascade = CascadeType.ALL)
    List<Transactions> transactionOfBook = new ArrayList<>();
}
