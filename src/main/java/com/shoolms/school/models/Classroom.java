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
@Table(name="classroom")
public class Classroom implements Serializable {
    @Id
    private Long id;
    private String nameClass;
    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;
}
