package com.shoolms.school.models;

import com.shoolms.school.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="attendance")
public class Attendance implements Serializable {

    @Id
    private Long id;
    private Date attendanceDate;
    private AttendanceStatus attendanceStatus;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name ="grade_id")
    private Grade grade;
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private  Classroom myClass;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

//    @ManyToOne
//    @JoinColumn(name = "teacher_id")
//    private Teacher teacher;

}