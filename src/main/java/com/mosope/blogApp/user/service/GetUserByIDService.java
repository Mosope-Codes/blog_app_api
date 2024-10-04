package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GetUserByIDService {
    private final UserRepository userRepository;

    public Map<String, Object> getUserById(Long id) {
        System.out.println(id);
        User user = userRepository.findById(id);
        return ResponseUtil.createSuceessResponse("User", user);
//        if (user != null) {
//            return ResponseUtil.createSuceessResponse("User", user);
//        }
//            return ResponseUtil.createErrorResponse("User Not Found");
    }
}
