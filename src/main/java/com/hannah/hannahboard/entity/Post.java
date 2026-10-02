package com.hannah.hannahboard.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.Instant;

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
    private User writer;

    @CreationTimestamp
    private Timestamp createdAt;

    private String content;

    @Nullable
    @UpdateTimestamp
    private Timestamp editedAt;

    @Nullable
    private Timestamp deletedAt;

    public Post(Long id, String title, User writer, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public Post() {

    }

    public void delete() {
        this.deletedAt = Timestamp.from(Instant.now());
    }
}
