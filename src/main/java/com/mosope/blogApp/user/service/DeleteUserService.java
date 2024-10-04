package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeleteUserService {
    private final UserRepository userRepository;
    public Map<String, Object> deleteUser(Long userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            userRepository.deleteById(userId);
            return ResponseUtil.createSuceessResponse("User deleted successfully");
        } else {
            return ResponseUtil.createErrorResponse("User not found");
        }
    }
}
