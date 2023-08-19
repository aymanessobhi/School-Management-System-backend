package com.shoolms.school.service.Impl;

import com.shoolms.school.models.Attendance;
import com.shoolms.school.repository.AttendanceRepository;
import com.shoolms.school.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttendanceServiceImp implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceImp(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
    @Override
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Optional<Attendance> existingAttendance = attendanceRepository.findById(id);
        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            attendance.setAttendanceDate(updatedAttendance.getAttendanceDate());
            attendance.setAttendanceStatus(updatedAttendance.getAttendanceStatus());
            attendance.setStudent(updatedAttendance.getStudent());
            attendance.setGrade(updatedAttendance.getGrade());
            attendance.setMyClass(updatedAttendance.getMyClass());
            attendance.setSection(updatedAttendance.getSection());
            // Update other fields as needed

            return attendanceRepository.save(attendance);
        } else {
            // Handle not found scenario
            return null;
        }
    }
    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
