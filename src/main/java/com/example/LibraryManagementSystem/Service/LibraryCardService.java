package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.LibraryCard;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Enums.Status;
import com.example.LibraryManagementSystem.Repository.LibraryCardDB;
import com.example.LibraryManagementSystem.Repository.StudentDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardService {
    @Autowired
    LibraryCardDB libraryCardDB;
    @Autowired
    StudentDB studentDB;

    public LibraryCard createLibraryCard() {
        LibraryCard lbCard = new LibraryCard();
        lbCard.setCardStatus(Status.NEW);
        libraryCardDB.save(lbCard);
        return lbCard;
    }

    public String associateCard(Integer studentId , Integer cardID) {
        System.out.println("Received studentId: " + studentId + ", cardID: " + cardID);
        Optional<Student> optionalStudent = studentDB.findById(studentId);
        Student student = optionalStudent.get();

        Optional<LibraryCard> optionalLibraryCard = libraryCardDB.findById(cardID);
        LibraryCard card = optionalLibraryCard.get();

        //setting att of library card
        card.setNameOnCard(student.getName());
        card.setCardStatus(Status.ACTIVE);
        card.setStudent(student);
        //setting att of student
        student.setLibraryCard(card);

        //saving student in student db
        studentDB.save(student);

        return "Card with card no. " + cardID +
                " has been Associated with student  with studentID " + studentId;

    }
}
