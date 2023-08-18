package com.shoolms.school.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class Student implements Serializable {
    @Id
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "Date_Birth")
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name="Grade_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name="classroom_id")
    private Classroom myClass;

    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;

    @ManyToOne
    @JoinColumn(name="nationalitie_id")
    private Nationalitie nationalitie;

    @Column(name = "academic_year")
    private String academicYear;

//    @ManyToOne
//    @JoinColumn(name="parent_id")
//    private MyParent parent;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Attendance> attendanceList;

}
