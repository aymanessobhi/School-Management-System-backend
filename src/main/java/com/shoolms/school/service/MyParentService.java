package com.shoolms.school.service;

import com.shoolms.school.models.MyParent;

import java.util.List;
import java.util.Optional;

public interface MyParentService {
    List<MyParent> getAllParents();
    Optional<MyParent> getParentById(Long id);
    MyParent saveParent(MyParent parent);
    MyParent updateParent(Long id, MyParent updatedParent);
    void deleteParent(Long id);
}
