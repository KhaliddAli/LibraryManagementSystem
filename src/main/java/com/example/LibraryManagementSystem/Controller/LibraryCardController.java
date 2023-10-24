package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Entity.LibraryCard;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Service.LibraryCardService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library-card")
public class LibraryCardController {
    @Autowired
    LibraryCardService libraryCardService;

    @PostMapping("/create-card")
    public ResponseEntity generateCard() {
        LibraryCard card = libraryCardService.createLibraryCard();

        return new ResponseEntity("Library Card Create" , HttpStatus.OK);
    }

    @PutMapping("/associate-card-with-student/")
    public ResponseEntity associatecard(@RequestParam("studentID")Integer studentID,@RequestParam("cardID")Integer cardID) {

        System.out.println("Received studentId: " + studentID + ", cardID: " + cardID);
        String response = libraryCardService.associateCard(studentID , cardID);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
