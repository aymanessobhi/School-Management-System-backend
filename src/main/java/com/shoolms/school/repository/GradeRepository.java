package com.shoolms.school.repository;

import com.shoolms.school.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GradeRepository extends JpaRepository<Grade,Long> {

}
