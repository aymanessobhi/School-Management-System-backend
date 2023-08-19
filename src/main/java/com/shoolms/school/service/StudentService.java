package com.shoolms.school.service;

import com.shoolms.school.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Student updateStudent(Long id, Student updatedStudent);
    Optional<Student> findById(Long id);
    List<Student>findAll();
    void delete(Long id);
}
