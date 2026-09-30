package com.hannah.hannahboard.component;

import com.hannah.hannahboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PostHitsFlushScheduler {

    private final PostService postService;

    @Scheduled(cron = "0 */5 * * * *")
    public void flushHits() {
        System.out.println("scheduler running: " + LocalDateTime.now());
        postService.flushHits();
    }
}
