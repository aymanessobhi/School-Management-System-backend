package com.shoolms.school.controllers;

import com.shoolms.school.models.Gender;
import com.shoolms.school.models.Specialization;
import com.shoolms.school.models.Teacher;
import com.shoolms.school.service.GenderService;
import com.shoolms.school.service.SpecializationService;
import com.shoolms.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeacherController {

    private final TeacherService teacherService;
    private final GenderService genderService;
    private final SpecializationService specializationService;

    @Autowired
    public TeacherController(TeacherService teacherService, GenderService genderService, SpecializationService specializationService) {
        this.teacherService = teacherService;
        this.genderService = genderService;
        this.specializationService = specializationService;
    }

    @GetMapping("/api/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/api/teachers/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/api/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("/api/teachers/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/api/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
    @GetMapping("/api/specializations")
    public List<Specialization> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }

    @GetMapping("/api/genders")
    public List<Gender> getAllGenders() {
        return genderService.getAllGenders();
    }

}
