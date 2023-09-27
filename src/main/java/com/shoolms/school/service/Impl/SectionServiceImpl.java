package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Section;
import com.shoolms.school.models.Teacher;
import com.shoolms.school.repository.SectionRepository;
import com.shoolms.school.repository.TeacherRepository;
import com.shoolms.school.service.SectionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository, TeacherRepository teacherRepository) {
        this.sectionRepository = sectionRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Optional<Section> getSectionById(Long id) {
        return sectionRepository.findById(id);
    }

    @Override
    @Transactional
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }
    @Override
    @Transactional
    public Section updateSection(Long id, Section updatedSection) {
        Optional<Section> existingSection = sectionRepository.findById(id);
        if (existingSection.isPresent()) {
            Section section = existingSection.get();
            // Update the fields of the section object with values from updatedSection
            section.setName_section(updatedSection.getName_section());
            section.setGrade(updatedSection.getGrade());
            section.setMyClass(updatedSection.getMyClass());
            return sectionRepository.save(section);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public List<Section> findByGrade(Long gradeId) {
        return sectionRepository.findSectionByGradeId(gradeId);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
    @Override
    public void addTeachersToSection(Long sectionId, List<Long> teacherIds) {
         Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new EntityNotFoundException("Section not found"));
         List<Teacher> teachers = teacherRepository.findAllById(teacherIds);
         section.getTeachers().addAll(teachers);
         sectionRepository.save(section);
    }
    @Override
    public void removeTeachersFromSection(Long sectionId, List<Long> teacherIds) {
         Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new EntityNotFoundException("Section not found"));
         List<Teacher> teachers = teacherRepository.findAllById(teacherIds);
         section.getTeachers().removeAll(teachers);
         sectionRepository.save(section);
    }
}
