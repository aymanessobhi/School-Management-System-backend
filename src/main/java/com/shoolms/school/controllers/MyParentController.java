package com.shoolms.school.controllers;

import com.shoolms.school.models.MyParent;
import com.shoolms.school.service.MyParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MyParentController {

    private final MyParentService myParentService;

    @Autowired
    public MyParentController(MyParentService myParentService) {
        this.myParentService = myParentService;
    }

    @GetMapping("/api/parents")
    public ResponseEntity<List<MyParent>> getAllParents() {
        List<MyParent> parents = myParentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }


    @GetMapping("/api/parents/{id}")
    public ResponseEntity<MyParent> getParentById(@PathVariable Long id) {
        Optional<MyParent> parent = myParentService.getParentById(id);
        return parent.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/parents")
    public ResponseEntity<MyParent> saveParent(@RequestBody MyParent parent) {
        MyParent savedParent = myParentService.saveParent(parent);
        return new ResponseEntity<>(savedParent, HttpStatus.CREATED);
    }

    @PutMapping("/api/parents/{id}")
    public ResponseEntity<MyParent> updateParent(@PathVariable Long id, @RequestBody MyParent updatedParent) {
        MyParent updated = myParentService.updateParent(id, updatedParent);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/api/parents/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        myParentService.deleteParent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
