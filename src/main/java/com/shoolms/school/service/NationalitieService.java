package com.shoolms.school.service;

import com.shoolms.school.models.Nationalitie;

import java.util.List;
import java.util.Optional;

public interface NationalitieService {
    List<Nationalitie> getAllNationalities();
    Optional<Nationalitie> getNationalitieById(Long id);
    Nationalitie saveNationalitie(Nationalitie nationalitie);
    Nationalitie updateNationalitie(Long id, Nationalitie updatedNationalitie);
    void deleteNationalitie(Long id);
}
