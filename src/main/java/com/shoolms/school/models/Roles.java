package com.shoolms.school.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{
    @Id
    private Long id;

    @Column(name = "rolename")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private User utilisateur;
}
