package com.hannah.hannahboard.dto;

import com.hannah.hannahboard.entity.User;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserResponse {
    private final Long id;
    private final String username;
    private final String status;
    private final String role;
    private final Timestamp createdAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.status = user.getStatus().name();
        this.role = user.getRole().name();
        this.createdAt = user.getCreatedAt();
    }

    public static UserResponse of(User user) {
        return new UserResponse(user);
    }
}
