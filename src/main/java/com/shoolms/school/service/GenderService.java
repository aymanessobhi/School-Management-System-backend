package com.shoolms.school.service;

import com.shoolms.school.models.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {
    List<Gender> getAllGenders();
    Optional<Gender> getGenderById(Long id);
    Gender saveGender(Gender gender);

    Gender updateGender(Long id, Gender updatedGender);

    void deleteGender(Long id);
}
