package dto;

import com.hannah.hannahboard.entity.Post;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final long hits;
    private final Timestamp createdAt;

    public PostResponse(Long id, String title, String content, long hits, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hits = hits;
        this.createdAt = createdAt;
    }

    public PostResponse(Post post, long cachedHits) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.hits = post.getHits() + cachedHits;
        this.createdAt = post.getCreatedAt();
    }

    public static PostResponse of(Post post, long cachedHits) {
        return new PostResponse(post, cachedHits);
    }
}
