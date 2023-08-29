package com.shoolms.school.service;

import com.shoolms.school.models.Religion;

import java.util.List;
import java.util.Optional;

public interface ReligionService {
    List<Religion> getAllReligions();
    Optional<Religion> getReligionById(Long id);
    Religion saveReligion(Religion religion);
    Religion updateReligion(Long id, Religion updatedReligion);
    void deleteReligion(Long id);
}
