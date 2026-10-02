package com.hannah.hannahboard.service;

import com.hannah.hannahboard.dto.UserRequest;
import com.hannah.hannahboard.dto.UserResponse;
import com.hannah.hannahboard.entity.User;
import com.hannah.hannahboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse signUp(UserRequest request) throws Exception {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        if (isUsernamePresent(request.getUsername())) {
            throw new Exception("Username is occupied.");
        }
        User user = userRepository.save(request.toEntity(encodedPassword));
        return UserResponse.of(user);
    }

    public UserResponse getUser(Long id) {
        return UserResponse.of(userRepository.findById(id).orElseThrow());
    }

    public boolean isUsernamePresent(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public UserResponse login(UserRequest request) throws Exception {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        if (!user.getPassword().equals(encodedPassword)) {
            throw new Exception("password not matched.");
        }

        return UserResponse.of(user);
    }
}
