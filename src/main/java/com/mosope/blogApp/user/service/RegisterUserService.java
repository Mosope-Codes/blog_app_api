package com.mosope.blogApp.user.service;

import com.mosope.blogApp.ResponseUtil;
import com.mosope.blogApp.user.CreateUserRequestDto;
import com.mosope.blogApp.user.User;
import com.mosope.blogApp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RegisterUserService {
    private final UserRepository userRepository;

    public Map<String, Object> registerUser(CreateUserRequestDto createUserRequestDto){
//        User existingUser = userRepository.findByEmail(createUserRequestDto.getEmail());
//        if(existingUser == null){
//            throw new RuntimeException();
//        }
        User user = mapCreateUserRequestDtoToUserEntity(createUserRequestDto);
        userRepository.save(user);
        return ResponseUtil.createSuceessResponse("User registered successfully!");
    }

    User mapCreateUserRequestDtoToUserEntity(CreateUserRequestDto createUserRequestDto){
        User user = new User();
        user.setFirstName(createUserRequestDto.getFirstName());
        user.setLastName(createUserRequestDto.getLastName());
        user.setUsername(createUserRequestDto.getUsername());
        user.setEmail(createUserRequestDto.getEmail());
        user.setPassword(hashPassword(createUserRequestDto.getPassword()));
        return user;
    }

    String hashPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.encode(password);
    }
}
