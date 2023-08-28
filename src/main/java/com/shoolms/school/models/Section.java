package com.shoolms.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoolms.school.enums.SectionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name_section;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="grade_id")
    private Grade grade;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="class_id")
    private Classroom myClass;

    @Enumerated(EnumType.STRING)
    private SectionStatus status;

//    @ManyToMany(mappedBy = "sections")
//    private List<Teacher> teachers;

}
