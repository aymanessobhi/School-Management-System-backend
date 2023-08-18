package com.shoolms.school.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="classroom")
public class Classroom implements Serializable {
    @Id
    private Long id;
    private String name_class;
    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;
}
