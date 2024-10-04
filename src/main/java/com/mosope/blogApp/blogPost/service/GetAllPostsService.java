package com.mosope.blogApp.blogPost.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.blogPost.BlogPost;
import com.mosope.blogApp.blogPost.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetAllPostsService {
    private final BlogPostRepository blogPostRepository;

    public Map<String, Object> getAllPosts(Pageable pageable) {
        Page<BlogPost> blogPosts = blogPostRepository.findAll(pageable);
        return ResponseUtil.createSuceessResponse("Blog Posts", blogPosts);
    }
}
