package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Classroom;
import com.shoolms.school.models.Grade;
import com.shoolms.school.repository.ClassroomRepository;
import com.shoolms.school.repository.GradeRepository;
import com.shoolms.school.service.ClassroomService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClassroomServiceImp implements ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public ClassroomServiceImp(ClassroomRepository classroomRepository,GradeRepository gradeRepository) {
        this.classroomRepository = classroomRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    @Transactional
    public Classroom saveClassroom(Classroom classroom) {
        Grade grade = classroom.getGrade(); // Get the associated Grade from the Classroom

        if (grade.getId() == null) {
            // Save and manage the Grade entity
            grade = gradeRepository.save(grade);
            classroom.setGrade(grade); // Set the managed Grade back to the Classroom
        } else {
            // If the Grade already has an ID, it's assumed to be managed.
            // You can perform additional checks if necessary.
        }

        return classroomRepository.save(classroom); // Save the Classroom
    }

    @Override
    public List<Classroom> findByGrade(Long gradeId) {
        return classroomRepository.findClassroomByGradeId(gradeId);
    }

    @Override
    @Transactional // Add @Transactional to ensure proper transaction management
    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        Optional<Classroom> existingClassroom = classroomRepository.findById(id);
        if (existingClassroom.isPresent()) {
            Classroom classroom = existingClassroom.get();
            classroom.setNameOfClass(updatedClassroom.getNameOfClass());
            classroom.setGrade(updatedClassroom.getGrade());
            // Handle updating the Grade if necessary (similar to saveClassroom logic)

            return classroomRepository.save(classroom);
        } else {
            // Handle not found scenario
            return null;
        }
    }
    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}
