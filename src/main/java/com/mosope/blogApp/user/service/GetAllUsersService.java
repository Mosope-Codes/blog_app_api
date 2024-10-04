package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetAllUsersService {
    private final UserRepository userRepository;
    public Map<String, Object> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return ResponseUtil.createSuceessResponse("Users", users);
    }
}
