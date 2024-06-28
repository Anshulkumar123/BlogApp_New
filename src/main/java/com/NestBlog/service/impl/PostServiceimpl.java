package com.NestBlog.service.impl;

import com.NestBlog.Payload.PostDto;
import com.NestBlog.entity.Post;
import com.NestBlog.repository.PostRepository;
import com.NestBlog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceimpl implements PostService {
    private PostRepository postRepository;

    public PostServiceimpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = MapToEntity(postDto);

        Post savedpost = postRepository.save(post);

        PostDto dto = MapToEntity(savedpost);

        return dto;
    }

    Post MapToEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(post.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

    PostDto MapToEntity(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
}
