package com.shoolms.school.repository;

import com.shoolms.school.models.FilesParent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FilesParent,Long> {
    List<FilesParent> findByMyParentId(Long parentId);
}
