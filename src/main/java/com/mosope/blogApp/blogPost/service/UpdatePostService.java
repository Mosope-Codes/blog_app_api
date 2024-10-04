package com.mosope.blogApp.blogPost.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.blogPost.BlogPost;
import com.mosope.blogApp.blogPost.BlogPostRepository;
import com.mosope.blogApp.blogPost.CreateBlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UpdatePostService {
    private final BlogPostRepository blogPostRepository;

    public Map<String, Object> updatePost(Long userId, Long postId, CreateBlogRequestDto blogPost) {
        BlogPost updatedBlogPost = blogPostRepository.findByAuthorIdAndId(userId, postId);
        if (updatedBlogPost != null) {
            updatedBlogPost.setTitle(blogPost.getTitle());
            updatedBlogPost.setBody(blogPost.getBody());
            blogPostRepository.save(updatedBlogPost);
            return ResponseUtil.createSuceessResponse("Blog Post updated successfully");
        } else {
            return ResponseUtil.createErrorResponse("Blog Post does not exist");
        }
    }
}
