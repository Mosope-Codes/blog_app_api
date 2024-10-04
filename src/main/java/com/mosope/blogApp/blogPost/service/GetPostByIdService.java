package com.mosope.blogApp.blogPost.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.blogPost.BlogPost;
import com.mosope.blogApp.blogPost.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetPostByIdService {
    private final BlogPostRepository blogPostRepository;

    public Map<String, Object> getPostById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id);
        if (blogPost != null) {
            return ResponseUtil.createSuceessResponse("Blog Post", blogPost);
        } else {
            return ResponseUtil.createErrorResponse("Blog Post Not Found");
        }
    }
}
