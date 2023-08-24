package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Classroom;
import com.shoolms.school.repository.ClassroomRepository;
import com.shoolms.school.service.ClassroomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClassroomServiceImp implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomServiceImp(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
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
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> findByGrade(Long gradeId) {
        return classroomRepository.findClassroomByGradeId(gradeId);
    }

    @Override
    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        Optional<Classroom> existingClassroom = classroomRepository.findById(id);
        if (existingClassroom.isPresent()) {
            Classroom classroom = existingClassroom.get();
            classroom.setNameOfClass(updatedClassroom.getNameOfClass());
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
