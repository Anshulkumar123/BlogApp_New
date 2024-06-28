package com.NestBlog.service.impl;

import com.NestBlog.Payload.PostDto;
import com.NestBlog.entity.Post;
import com.NestBlog.repository.PostRepository;
import com.NestBlog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Service
public class PostServiceimpl implements PostService {
    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceimpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper= modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = MapToEntity(postDto);

        Post savedpost = postRepository.save(post);

        PostDto dto = MapToEntity(savedpost);

        return dto;
    }

    Post MapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

    PostDto MapToEntity(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }
}
