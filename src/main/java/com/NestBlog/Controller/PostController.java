package com.NestBlog.Controller;

import com.NestBlog.Payload.PostDto;
import com.NestBlog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/6
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return new ResponseEntity<>("post is deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> fetchAllPosts(){
        List<PostDto> postDtos = postService.fetchAllPosts();
        return new ResponseEntity<>(postDtos, HttpStatus.OK);
    }

}
