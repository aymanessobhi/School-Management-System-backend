package com.shoolms.school.repository;

import com.shoolms.school.models.FilesParent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FilesParent,Long> {
}
