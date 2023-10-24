package com.example.LibraryManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentID;

    private String name;

    private String bloodGroup;

    private Integer age;

    private long contact_No;

    private String email;


    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
    @JsonIgnore
    LibraryCard libraryCard;

}
