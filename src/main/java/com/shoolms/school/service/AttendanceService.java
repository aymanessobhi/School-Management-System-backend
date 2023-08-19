package com.shoolms.school.service;

import com.shoolms.school.models.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    List<Attendance> getAllAttendances();
    Optional<Attendance> getAttendanceById(Long id);
    Attendance saveAttendance(Attendance attendance);

    Attendance updateAttendance(Long id, Attendance updatedAttendance);

    void deleteAttendance(Long id);
}
