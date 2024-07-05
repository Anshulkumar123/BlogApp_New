package com.NestBlog.service;

import com.NestBlog.Payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(long id);

    List<PostDto> fetchAllPosts();
}
