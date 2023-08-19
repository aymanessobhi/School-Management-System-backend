package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Attendance;
import com.shoolms.school.models.Student;
import com.shoolms.school.repository.StudentRepository;
import com.shoolms.school.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImp implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImp(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            // Update the fields of the student object with values from updatedStudent
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setDateOfBirth(updatedStudent.getDateOfBirth());
            student.setGender(updatedStudent.getGender());
            student.setGrade(updatedStudent.getGrade());
            student.setMyClass(updatedStudent.getMyClass());
            student.setSection(updatedStudent.getSection());
            student.setNationalitie(updatedStudent.getNationalitie());
            student.setAcademicYear(updatedStudent.getAcademicYear());
//            List<Attendance> updatedAttendanceList = updatedStudent.getAttendanceList();
//            if (updatedAttendanceList != null) {
//                student.getAttendanceList().clear();
//                student.getAttendanceList().addAll(updatedAttendanceList);
//            }
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
