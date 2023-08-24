package com.shoolms.school.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @CreatedDate
    @Column(name="createDate",nullable = false,updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name="lastModifiedDate")
    private LocalDateTime lastModifiedDate;
}
