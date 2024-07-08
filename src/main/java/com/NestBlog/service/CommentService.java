package com.NestBlog.service;

import com.NestBlog.Payload.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);
}
