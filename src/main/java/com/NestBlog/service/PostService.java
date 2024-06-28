package com.NestBlog.service;

import com.NestBlog.Payload.PostDto;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);
}
