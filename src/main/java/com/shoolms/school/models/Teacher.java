package com.shoolms.school.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String email;
    private String password;
    private String name;
    @ManyToOne
    @JoinColumn(name="Specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name="Gender_id")
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date joiningData;

    @Lob
    private String address;
    @ManyToMany
    @JoinTable(
            name="teacher_section",
            joinColumns = @JoinColumn(name="teacher_id"),
            inverseJoinColumns = @JoinColumn(name="section_id")
    )
    private List<Section> sections;
}
