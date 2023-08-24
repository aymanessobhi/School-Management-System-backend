package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Nationalitie;
import com.shoolms.school.repository.NationalitieRepository;
import com.shoolms.school.service.NationalitieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NationalitieServiceImp implements NationalitieService {
    private NationalitieRepository nationalitieRepository;

    @Autowired
    public void NationalitieServiceImpl(NationalitieRepository nationalitieRepository) {
        this.nationalitieRepository = nationalitieRepository;
    }

    @Override
    public List<Nationalitie> getAllNationalities() {
        return nationalitieRepository.findAll();
    }

    @Override
    public Optional<Nationalitie> getNationalitieById(Long id) {
        return nationalitieRepository.findById(id);
    }

    @Override
    public Nationalitie saveNationalitie(Nationalitie nationalitie) {
        return nationalitieRepository.save(nationalitie);
    }
    @Override
    public Nationalitie updateNationalitie(Long id, Nationalitie updatedNationalitie) {
        Optional<Nationalitie> existingNationalitie = nationalitieRepository.findById(id);
        if (existingNationalitie.isPresent()) {
            Nationalitie nationalitie = existingNationalitie.get();
            nationalitie.setNameNationalitie(updatedNationalitie.getNameNationalitie());
            return nationalitieRepository.save(nationalitie);
        } else {
            return null;
        }
    }

    @Override
    public void deleteNationalitie(Long id) {
        nationalitieRepository.deleteById(id);
    }
}
