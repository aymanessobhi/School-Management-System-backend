package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Grade;
import com.shoolms.school.repository.GradeRepository;
import com.shoolms.school.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GradeServiceImp implements GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImp(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    @Override
    public Grade updateGrade(Long id, Grade updatedGrade) {
        Optional<Grade> existingGrade = gradeRepository.findById(id);
        if (existingGrade.isPresent()) {
            Grade grade = existingGrade.get();
            // Update the fields of the grade object with values from updatedGrade
            grade.setNameGrade(updatedGrade.getNameGrade());
            grade.setNotes(updatedGrade.getNotes());

            return gradeRepository.save(grade);
        } else {
            // Handle not found scenario
            return null;
        }
    }


    @Override
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
