package com.shoolms.school.models;

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
    private String nameGrade;
    private String notes;
}
