package com.shoolms.school.models;

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
public class Section implements Serializable {
    @Id
    private Long id;
    private String name_section;
    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;
    @ManyToOne
    @JoinColumn(name="class_id")
    private Classroom myClass;

//    @ManyToMany(mappedBy = "sections")
//    private List<Teacher> teachers;

}
