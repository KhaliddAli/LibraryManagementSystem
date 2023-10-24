package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Repository.StudentDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDB studentDB;

    public void addStudent(Student student) {
        studentDB.save(student);
    }
}
