package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDB extends JpaRepository<Student, Integer> {
}
