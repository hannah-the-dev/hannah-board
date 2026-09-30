package com.hannah.hannahboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private CommonStatus status;

    @CreationTimestamp
    private Timestamp createdAt;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.role = role;
        this.status = CommonStatus.NORMAL;
        this.password = password;
    }

}
