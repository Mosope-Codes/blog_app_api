package com.mosope.blogApp.blogPost;

import lombok.Data;

@Data
public class CreateBlogResponseDto {
    private String title;
    private String body;
    private String author;
}
