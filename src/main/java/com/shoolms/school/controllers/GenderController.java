package com.shoolms.school.controllers;

import com.shoolms.school.models.Gender;
import com.shoolms.school.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    private final GenderService genderService;

    @Autowired
    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderService.getAllGenders();
        return ResponseEntity.ok(genders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> getGenderById(@PathVariable Long id) {
        return genderService.getGenderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Gender> saveGender(@RequestBody Gender gender) {
        Gender savedGender = genderService.saveGender(gender);
        return ResponseEntity.ok(savedGender);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender updatedGender) {
        Gender updated = genderService.updateGender(id, updatedGender);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        genderService.deleteGender(id);
        return ResponseEntity.noContent().build();
    }
}
