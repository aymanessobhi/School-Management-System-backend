package com.shoolms.school.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="grade")
public class Grade implements Serializable {
    @Id
    private Long id;
    private String name_grade;
    private String notes;
}
