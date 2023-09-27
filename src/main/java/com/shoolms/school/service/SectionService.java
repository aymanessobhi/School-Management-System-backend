package com.shoolms.school.service;

import com.shoolms.school.models.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {
    List<Section> getAllSections();
    Optional<Section> getSectionById(Long id);
    Section saveSection(Section section);
    Section updateSection(Long id, Section updatedSection);
    List<Section> findByGrade(Long gradeId);
    void deleteSection(Long id);
    void addTeachersToSection(Long sectionId, List<Long> teacherIds);
    void removeTeachersFromSection(Long sectionId, List<Long> teacherIds);
}
