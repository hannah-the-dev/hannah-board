package com.hannah.hannahboard.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table
@Getter
@Setter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private long hits;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name="writer_id")
    private User writerId;

    @CreationTimestamp
    private Timestamp createdAt;

    private String content;

    @Nullable
    private Timestamp editedAt;

    @Nullable
    private Timestamp deletedAt;
}
