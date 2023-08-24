package com.shoolms.school.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Promotion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "from_grade")
    private Grade fromGrade;

    @ManyToOne
    @JoinColumn(name = "from_Classroom")
    private Classroom fromClassroom;

    @ManyToOne
    @JoinColumn(name = "from_section")
    private Section fromSection;

    @ManyToOne
    @JoinColumn(name = "to_grade")
    private Grade toGrade;

    @ManyToOne
    @JoinColumn(name = "to_Classroom")
    private Classroom toClassroom;

    @ManyToOne
    @JoinColumn(name = "to_section")
    private Section toSection;

    @Column(name = "academic_year")
    private String academicYear;

    @Column(name = "academic_year_new")
    private String academicNewYear;

}
