package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetUserByEmailService {
    private final UserRepository userRepository;

    public Map<String, Object> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return ResponseUtil.createSuceessResponse("User", user);
        } else{
            return ResponseUtil.createErrorResponse("User Not Found");
        }
    }
}
