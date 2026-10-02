package com.hannah.hannahboard.dto;

import com.hannah.hannahboard.entity.User;
import com.hannah.hannahboard.entity.UserRole;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserRequest {
    private final String username;
    private final String status;
    private final String role;
    private final Timestamp createdAt;
    private String password;

    public UserRequest(User user) {
        this.username = user.getUsername();
        this.status = user.getStatus().name();
        this.role = user.getRole().name();
        this.createdAt = user.getCreatedAt();
    }

    public User toEntity(String encodedPassword) {
        return new User(
                this.username,
                encodedPassword,
                UserRole.valueOf(this.role)
        );
    }
}
