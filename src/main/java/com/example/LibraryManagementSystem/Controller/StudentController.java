package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) {
        try{
            studentService.addStudent(student);
            return "Student added successfully !";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
