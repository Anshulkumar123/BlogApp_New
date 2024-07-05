package com.NestBlog.service.impl;

import com.NestBlog.Payload.PostDto;
import com.NestBlog.entity.Post;
import com.NestBlog.repository.PostRepository;
import com.NestBlog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

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

        PostDto dto = mapToDto(savedpost);

        return dto;
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> fetchAllPosts() {
        List<Post> post = postRepository.findAll();
        List<PostDto> postDtos = post.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return postDtos;
    }


    Post MapToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

    PostDto mapToDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }
}
