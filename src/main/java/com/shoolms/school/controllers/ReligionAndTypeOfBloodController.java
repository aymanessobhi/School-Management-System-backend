package com.shoolms.school.controllers;

import com.shoolms.school.models.Nationalitie;
import com.shoolms.school.models.Religion;
import com.shoolms.school.models.Type_Blood;
import com.shoolms.school.service.NationalitieService;
import com.shoolms.school.service.ReligionService;
import com.shoolms.school.service.TypeBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ReligionAndTypeOfBloodController {
    private final ReligionService religionService;
    private final TypeBloodService typeBloodService;
    @Autowired
    public ReligionAndTypeOfBloodController(ReligionService religionService, TypeBloodService typeBloodService) {
        this.religionService = religionService;
        this.typeBloodService = typeBloodService;
    }
    @GetMapping("/api/religions")
    public ResponseEntity<List<Religion>> getAllReligions() {
        List<Religion> religions = religionService.getAllReligions();
        return ResponseEntity.ok(religions);
    }
    @GetMapping("/api/typeBloods")
    public ResponseEntity<List<Type_Blood>> getAllBloodTypes() {
        List<Type_Blood> typeBloods = typeBloodService.getAllBloodTypes();
        return ResponseEntity.ok(typeBloods);
    }

}
