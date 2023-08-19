package com.shoolms.school.repository;

import com.shoolms.school.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Roles,Long> {
}
