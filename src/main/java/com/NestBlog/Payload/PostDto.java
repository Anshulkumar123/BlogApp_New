package com.NestBlog.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
    private long id;
    @NotEmpty
    @Size(min = 3, message = "title should be at lest 3 character")
    private String title;
    @NotEmpty
    @Size(min = 3, message = "Description should be at least 3 character")
    private String description ;
    private String content;
}
