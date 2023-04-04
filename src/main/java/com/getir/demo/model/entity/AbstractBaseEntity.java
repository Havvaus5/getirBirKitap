package com.getir.demo.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "CREATOR_USER_ID", nullable = false)
    @CreatedBy
    private int creatorUserId;

    @Column(name = "CREATED_TIME", nullable = false)
    @CreatedDate
    private LocalDateTime createdTime;

    @Column(name = "UPDATED_USER_ID", nullable = false)
    @LastModifiedBy
    private int updatedUserId;

    @Column(name = "UPDATED_TIME", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedTime;

}
