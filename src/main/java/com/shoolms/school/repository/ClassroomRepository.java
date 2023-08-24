package com.shoolms.school.repository;

import com.shoolms.school.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    List<Classroom> findClassroomByGradeId(Long gradeId);
}
