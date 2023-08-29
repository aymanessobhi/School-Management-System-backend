package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Religion;
import com.shoolms.school.repository.ReligionRepository;
import com.shoolms.school.service.ReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReligionServiceImp implements ReligionService {

    private final ReligionRepository religionRepository;

    @Autowired
    public ReligionServiceImp(ReligionRepository religionRepository) {
        this.religionRepository = religionRepository;
    }

    @Override
    public List<Religion> getAllReligions() {
        return religionRepository.findAll();
    }

    @Override
    public Optional<Religion> getReligionById(Long id) {
        return Optional.empty();
    }

    @Override
    public Religion saveReligion(Religion religion) {
        return religionRepository.save(religion);
    }

    @Override
    public Religion updateReligion(Long id, Religion updatedReligion) {
        return null;
    }

    @Override
    public void deleteReligion(Long id) {

    }
}
