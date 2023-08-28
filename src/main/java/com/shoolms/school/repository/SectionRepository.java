package com.shoolms.school.repository;

import com.shoolms.school.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section,Long> {
    List<Section> findSectionByGradeId(Long sectionId);
}
