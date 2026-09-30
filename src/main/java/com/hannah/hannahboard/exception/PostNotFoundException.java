package com.hannah.hannahboard.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(Long id) {
        super("Post (" + id + ") not found.");
    }
}
