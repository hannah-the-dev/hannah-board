package com.hannah.hannahboard.dto;

import com.hannah.hannahboard.entity.Post;
import com.hannah.hannahboard.entity.User;
import lombok.Getter;

@Getter
public class PostRequest {
    private final Long id;
    private final Long writerId;
    private final String title;
    private final String content;

    public PostRequest(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerId = post.getWriter().getId();
    }

    public Post toEntity(User writer) {
        return new Post(
                this.id,
                this.title,
                writer,
                this.content
        );
    }
}
