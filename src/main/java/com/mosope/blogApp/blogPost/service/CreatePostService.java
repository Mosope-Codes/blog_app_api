package com.mosope.blogApp.blogPost.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.blogPost.BlogPost;
import com.mosope.blogApp.blogPost.BlogPostRepository;
import com.mosope.blogApp.blogPost.CreateBlogRequestDto;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CreatePostService {
    private final BlogPostRepository blogPostRepository;
    private final UserRepository userRepository;
    public Map<String, Object> createPost(CreateBlogRequestDto createBlogRequestDto, Long userId) {
        User author = userRepository.findById(userId);
        if(createBlogRequestDto != null) {
            BlogPost blogPost = new BlogPost();
            blogPost.setTitle(createBlogRequestDto.getTitle());
            blogPost.setBody(createBlogRequestDto.getBody());
            blogPost.setAuthor(author);
            blogPostRepository.save(blogPost);
            return ResponseUtil.createSuceessResponse("Blog Post Created Successfully");
        } else {
            return ResponseUtil.createErrorResponse("Blog Post is Empty");
        }

    }
}
