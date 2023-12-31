package com.shoolms.school.controllers;

import com.shoolms.school.models.Nationalitie;
import com.shoolms.school.service.NationalitieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NationalitieController {

    private final NationalitieService nationalitieService;

    @Autowired
    public NationalitieController(NationalitieService nationalitieService) {
        this.nationalitieService = nationalitieService;
    }

    @GetMapping("/api/nationalities")
    public ResponseEntity<List<Nationalitie>> getAllNationalities() {
        List<Nationalitie> nationalities = nationalitieService.getAllNationalities();
        return ResponseEntity.ok(nationalities);
    }

    @GetMapping("/api/nationalities/{id}")
    public ResponseEntity<Nationalitie> getNationalitieById(@PathVariable Long id) {
        return nationalitieService.getNationalitieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/api/nationalities")
    public ResponseEntity<Nationalitie> saveNationalitie(@RequestBody Nationalitie nationalitie) {
        Nationalitie savedNationalitie = nationalitieService.saveNationalitie(nationalitie);
        return ResponseEntity.ok(savedNationalitie);
    }
    @PatchMapping("/api/nationalities/{id}")
    public ResponseEntity<Nationalitie> updateNationalitie(@PathVariable Long id, @RequestBody Nationalitie updatedNationalitie) {
        Nationalitie updated = nationalitieService.updateNationalitie(id, updatedNationalitie);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/nationalities/{id}")
    public ResponseEntity<Void> deleteNationalitie(@PathVariable Long id) {
        nationalitieService.deleteNationalitie(id);
        return ResponseEntity.noContent().build();
    }
}
