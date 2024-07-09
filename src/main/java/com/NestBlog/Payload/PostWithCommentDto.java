package com.NestBlog.Payload;

import com.NestBlog.entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostWithCommentDto {

    private Post post;
    private List<CommentDto> commentDto;

}
