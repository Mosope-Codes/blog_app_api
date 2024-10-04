package com.mosope.blogApp.blogPost;

import com.mosope.blogApp.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogPostRepository extends PagingAndSortingRepository<BlogPost, Long> {
    BlogPost save(BlogPost blogPost);
    BlogPost findById(Long id);
    BlogPost findByAuthorIdAndId(Long author, Long id);
    void deleteById(Long id);
    BlogPost findByAuthorId(Long id);
}
