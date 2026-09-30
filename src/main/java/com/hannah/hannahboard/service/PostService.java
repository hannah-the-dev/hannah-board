package com.hannah.hannahboard.service;

import com.hannah.hannahboard.entity.Post;
import com.hannah.hannahboard.exception.PostNotFoundException;
import com.hannah.hannahboard.repository.PostRepository;
import dto.PostResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {
    private final StringRedisTemplate redisTemplate;
    @Autowired
    private PostRepository postRepository;

    public void write(Post board) {
        postRepository.save(board);
    }

    public PostResponse getPost(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
        long bufferedHits = incrementHits(id);
        long totalHits = post.getHits() + bufferedHits;

        return PostResponse.of(post, totalHits);
    }

    private long incrementHits(Long id) {

        String viewKey = "post:hits:" + id;
        redisTemplate.opsForValue().increment(viewKey);
        String buffered = redisTemplate.opsForValue().get(viewKey);
        return (buffered != null) ? Long.parseLong(buffered) : 0L;
    }


    public Page<PostResponse> getList(Pageable pageable) {

        Page<Post> page = postRepository.findAll(pageable);
        List<String> keys = page.stream().map(post -> "post:hits:" + post.getId()).toList();
        List<Long> hits =
                redisTemplate.opsForValue().multiGet(keys).stream().map(v -> v == null ? 0L : Long.parseLong(v)).toList();
        List<PostResponse> result = new ArrayList<>();
        for (int i = 0; i < page.getNumberOfElements(); i++) {
            result.add(new PostResponse(page.getContent().get(i), hits.get(i)));
        }

        return new PageImpl<>(result, page.getPageable(), page.getTotalElements());
    }

    @Transactional
    public void flushHits() {
        Set<String> keys = redisTemplate.keys("post:hits:*");
        if (keys == null || keys.isEmpty()) return;

        for (String key : keys) {
            String count = redisTemplate.opsForValue().getAndDelete(key);
            if (count == null) continue;

            Long postId = Long.parseLong(key.split(":")[2]);
            postRepository.incrementViews(postId, Long.parseLong(count));
        }
    }
}
