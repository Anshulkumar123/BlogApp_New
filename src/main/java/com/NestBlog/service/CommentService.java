package com.NestBlog.service;

import com.NestBlog.Payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);

    public List<CommentDto> getAllCommentsByPostId(long id);
}
