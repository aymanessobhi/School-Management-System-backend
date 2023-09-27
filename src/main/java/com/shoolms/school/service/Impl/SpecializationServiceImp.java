package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Specialization;
import com.shoolms.school.repository.SpecializationRepository;
import com.shoolms.school.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializationServiceImp implements SpecializationService {
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationServiceImp(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public Specialization getSpecializationById(Long id) {
        Optional<Specialization> specialization = specializationRepository.findById(id);
        return specialization.orElse(null);
    }

    @Override
    public Specialization createSpecialization(Specialization specialization) {
        // You can add validation and business logic here if needed
        return specializationRepository.save(specialization);
    }

    @Override
    public Specialization updateSpecialization(Long id, Specialization specialization) {
        Optional<Specialization> existingSpecialization = specializationRepository.findById(id);
        if (existingSpecialization.isPresent()) {
            // Update the existing specialization properties with new values
            Specialization updatedSpecialization = existingSpecialization.get();
            updatedSpecialization.setName(specialization.getName());
            // Set other properties as needed

            return specializationRepository.save(updatedSpecialization);
        } else {
            return null;
        }
    }

    @Override
    public void deleteSpecialization(Long id) {
        specializationRepository.deleteById(id);
    }
}
