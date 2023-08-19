package com.shoolms.school.repository;

import com.shoolms.school.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByGradeId(Long gradeId);

}
