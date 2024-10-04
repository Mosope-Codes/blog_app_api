package com.mosope.blogApp.blogPost.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.blogPost.BlogPost;
import com.mosope.blogApp.blogPost.BlogPostRepository;
import com.mosope.blogApp.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeletePostService {
    private final BlogPostRepository blogPostRepository;

    public Map<String, Object> deleteById(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id);
        if (blogPost != null) {
            blogPostRepository.deleteById(id);
            return ResponseUtil.createSuceessResponse("User Deleted Successfully");
        } else {
            return ResponseUtil.createErrorResponse("Blog Post Not Found");
        }
    }
}
