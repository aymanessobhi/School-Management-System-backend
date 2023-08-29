package com.shoolms.school.service;

import com.shoolms.school.models.Type_Blood;

import java.util.List;
import java.util.Optional;

public interface TypeBloodService {
    List<Type_Blood> getAllBloodTypes();
    Optional<Type_Blood> getBloodTypeById(Long id);
    Type_Blood saveTypeBlood(Type_Blood bloodType);
    Type_Blood updateTypeBlood(Long id, Type_Blood updatedBloodType);
    void deleteBloodType(Long id);
}
