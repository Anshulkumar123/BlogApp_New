package com.NestBlog.service;

import com.NestBlog.Payload.CommentDto;
import com.NestBlog.Payload.PostWithCommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, long postId);

    public PostWithCommentDto getAllCommentsByPostId(long id);
}
