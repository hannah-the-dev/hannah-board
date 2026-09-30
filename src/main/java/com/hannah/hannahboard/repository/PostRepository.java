package com.hannah.hannahboard.repository;

import com.hannah.hannahboard.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Query("UPDATE Post p SET p.hits = p.hits + :increment WHERE p.id = :id")
    void incrementViews(@Param("id") Long id, @Param("increment") long increment);
}