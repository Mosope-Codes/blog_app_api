package com.mosope.blogApp.blogPost;

import com.mosope.blogApp.blogPost.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BlogPostController {

    private final CreatePostService createPostService;
    private final GetAllPostsService getAllPostsService;
    private final GetPostByIdService getPostByIdService;
    private final UpdatePostService updatePostService;
    private final DeletePostService deletePostService;
    private final GetPostByUserIdService getPostByUserIdService;

    @PostMapping("/post/{userId}")
    public ResponseEntity<Map<String, Object>> createNewBlogPost(@RequestBody CreateBlogRequestDto createBlogRequestDto, @PathVariable Long userId) {
        Map<String, Object> blogPost = createPostService.createPost(createBlogRequestDto, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost);
    }

    @GetMapping("/posts")
    public ResponseEntity<Map<String, Object>> getAllBlogPosts(Pageable pageable) {
        Map<String, Object> blogPosts = getAllPostsService.getAllPosts(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(blogPosts);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Map<String, Object>> getBlogPostById(@PathVariable Long id) {
        Map<String, Object> blogPost = getPostByIdService.getPostById(id);
        return ResponseEntity.status(HttpStatus.OK).body(blogPost);
    }

//    @GetMapping("/post/{userId}")
//    public ResponseEntity<Map<String, Object>> getBlogPostByUserId(@PathVariable Long userId) {
//        Map<String, Object> blogPost = getPostByUserIdService.getPostByUserId(userId);
//        return ResponseEntity.status(HttpStatus.OK).body(blogPost);
//    }


    @PutMapping("/post/{userId}/{postId}")
    public ResponseEntity<Map<String, Object>> updateBlogPost(@PathVariable Long userId, @PathVariable Long postId, @RequestBody CreateBlogRequestDto blogPost){
        Map<String, Object> updatedPost = updatePostService.updatePost(userId, postId, blogPost);
        return ResponseEntity.status(HttpStatus.OK).body(updatedPost);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Map<String, Object>> deleteBlogPost(@PathVariable Long id) {
        Map<String, Object> deletedPost = deletePostService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedPost);
    }


}
