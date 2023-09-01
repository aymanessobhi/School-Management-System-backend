package com.shoolms.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="parents")
public class MyParent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    // Father information
    private String nameFather;
    private String nationalIdFather;
    private String passportIdFather;
    private String phoneFather;
    private String jobFather;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_father_id")
    private Nationalitie nationalityFather;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blood_type_father_id")
    private Type_Blood bloodTypeFather;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "religion_father_id")
    private Religion religionFather;
    private String addressFather;

    // Mother information
    private String nameMother;
    private String nationalIdMother;
    private String passportIdMother;
    private String phoneMother;
    private String jobMother;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_mother_id")
    private Nationalitie nationalityMother;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blood_type_mother_id")
    private Type_Blood bloodTypeMother;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "religion_mother_id")
    private Religion religionMother;
    private String addressMother;

    @OneToMany(mappedBy = "myParent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FilesParent> files = new ArrayList<>();

}
