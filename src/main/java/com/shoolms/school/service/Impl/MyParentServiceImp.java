package com.shoolms.school.service.Impl;

import com.shoolms.school.models.MyParent;
import com.shoolms.school.repository.MyParentRepository;
import com.shoolms.school.service.MyParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyParentServiceImp implements MyParentService {
    private final MyParentRepository myParentRepository;

    @Autowired
    public MyParentServiceImp(MyParentRepository myParentRepository) {
        this.myParentRepository = myParentRepository;
    }

    @Override
    public List<MyParent> getAllParents() {
        return myParentRepository.findAll();
    }

    @Override
    public Optional<MyParent> getParentById(Long id) {
        return myParentRepository.findById(id);
    }

    @Override
    public MyParent saveParent(MyParent parent) {
        return myParentRepository.save(parent);
    }

    @Override
    public MyParent updateParent(Long id, MyParent updatedParent) {
        Optional<MyParent> existingParent = myParentRepository.findById(id);
        if (existingParent.isPresent()) {
            MyParent parentToUpdate = existingParent.get();
            // Update fields of parentToUpdate with corresponding fields from updatedParent
            // For example: parentToUpdate.setEmail(updatedParent.getEmail());
            // ... Update other fields
            return myParentRepository.save(parentToUpdate);
        }
        return null; // Handle case where parent doesn't exist with given id
    }

    @Override
    public void deleteParent(Long id) {
        myParentRepository.deleteById(id);
    }
}
