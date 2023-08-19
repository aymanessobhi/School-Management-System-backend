package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Gender;
import com.shoolms.school.repository.GenderRepository;
import com.shoolms.school.service.GenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GenderServiceImp implements GenderService {
    private final GenderRepository genderRepository;

    @Autowired
    public GenderServiceImp(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> getGenderById(Long id) {
        return genderRepository.findById(id);
    }

    @Override
    public Gender saveGender(Gender gender) {
        return genderRepository.save(gender);
    }
    @Override
    public Gender updateGender(Long id, Gender updatedGender) {
        Optional<Gender> existingGender = genderRepository.findById(id);
        if (existingGender.isPresent()) {
            Gender gender = existingGender.get();
            // Update the fields of the gender object with values from updatedGender
            gender.setNameGender(updatedGender.getNameGender());

            return genderRepository.save(gender);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public void deleteGender(Long id) {
        genderRepository.deleteById(id);
    }
}
