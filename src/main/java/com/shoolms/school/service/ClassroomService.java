package com.shoolms.school.service;

import com.shoolms.school.models.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {
    List<Classroom> getAllClassrooms();
    Optional<Classroom> getClassroomById(Long id);
    Classroom saveClassroom(Classroom classroom);
    List<Classroom> findByGrade(Long GradeId);
    Classroom updateClassroom(Long id, Classroom updatedClassroom);

    void deleteClassroom(Long id);
}
