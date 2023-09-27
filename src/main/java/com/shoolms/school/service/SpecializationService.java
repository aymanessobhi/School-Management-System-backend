package com.shoolms.school.service;

import com.shoolms.school.models.Specialization;

import java.util.List;

public interface SpecializationService {
        // Retrieve all specializations
        List<Specialization> getAllSpecializations();

        // Retrieve a specialization by ID
        Specialization getSpecializationById(Long id);

        // Create a new specialization
        Specialization createSpecialization(Specialization specialization);

        // Update an existing specialization
        Specialization updateSpecialization(Long id, Specialization specialization);

        // Delete a specialization by ID
        void deleteSpecialization(Long id);
}
