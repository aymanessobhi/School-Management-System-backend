package com.shoolms.school.service;

import com.shoolms.school.models.Grade;

import java.util.List;
import java.util.Optional;

public interface GradeService {
    List<Grade> getAllGrades();
    Optional<Grade> getGradeById(Long id);

    Grade updateGrade(Long id, Grade updatedGrade);

    Grade saveGrade(Grade grade);
    void deleteGrade(Long id);
}
