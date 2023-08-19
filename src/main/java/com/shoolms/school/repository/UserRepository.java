package com.shoolms.school.repository;

import com.shoolms.school.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
