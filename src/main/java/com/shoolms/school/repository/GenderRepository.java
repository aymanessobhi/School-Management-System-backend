package com.shoolms.school.repository;

import com.shoolms.school.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Long> {
}
