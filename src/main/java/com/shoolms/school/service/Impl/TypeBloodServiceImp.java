package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Type_Blood;
import com.shoolms.school.repository.TypeBloodRepository;
import com.shoolms.school.service.TypeBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeBloodServiceImp implements TypeBloodService {

    private final TypeBloodRepository typeBloodRepository;

    @Autowired
    public TypeBloodServiceImp(TypeBloodRepository typeBloodRepository) {
        this.typeBloodRepository = typeBloodRepository;
    }

    @Override
    public List<Type_Blood> getAllBloodTypes() {
        return typeBloodRepository.findAll();
    }

    @Override
    public Optional<Type_Blood> getBloodTypeById(Long id) {
        return typeBloodRepository.findById(id);
    }

    @Override
    public Type_Blood saveTypeBlood(Type_Blood bloodType) {
        return typeBloodRepository.save(bloodType);
    }

    @Override
    public Type_Blood updateTypeBlood(Long id, Type_Blood updatedBloodType) {
        Optional<Type_Blood> existingBloodType = typeBloodRepository.findById(id);
        if (existingBloodType.isPresent()) {
            Type_Blood bloodTypeToUpdate = existingBloodType.get();
            bloodTypeToUpdate.setNameBlood(updatedBloodType.getNameBlood());
            return typeBloodRepository.save(bloodTypeToUpdate);
        }
        return null; // Handle case where blood type doesn't exist with given id
    }

    @Override
    public void deleteBloodType(Long id) {
        typeBloodRepository.deleteById(id);
    }
}
