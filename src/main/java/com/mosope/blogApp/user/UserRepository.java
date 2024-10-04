package com.mosope.blogApp.user;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User save(User user);
    User findById(Long id);
    void deleteById(Long id);
    User findByEmail(String email);

}
