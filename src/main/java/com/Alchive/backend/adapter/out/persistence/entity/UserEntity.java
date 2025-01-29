package com.Alchive.backend.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

public class UserEntity {
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Long id;

    @Column(name = "email", length = 300, nullable = false)
    private String email;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "auto_save", nullable = false)
    @ColumnDefault("true")
    private Boolean autoSave = true;
    }
}