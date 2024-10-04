package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.CreateUserRequestDto;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UpdateUserService {
    private final UserRepository userRepository;

    public Map<String, Object> updateUser(CreateUserRequestDto user, Long userId) {
        User updatedUser = userRepository.findById(userId);
        if(updatedUser != null) {
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
            return ResponseUtil.createSuceessResponse("User successfully updated", updatedUser);
        }
        else {
            return ResponseUtil.createErrorResponse("User not found");
        }
    }
}
