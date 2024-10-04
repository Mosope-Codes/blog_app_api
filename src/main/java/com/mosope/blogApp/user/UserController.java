package com.mosope.blogApp.user;

import com.mosope.blogApp.user.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final RegisterUserService registerUserService;
    private final GetAllUsersService getAllUsersService;
    private final GetUserByIDService getUserByIDService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final GetUserByEmailService getUserByEmailService;


    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody CreateUserRequestDto createUserRequestDto){
        Map<String, Object> registerUser = registerUserService.registerUser(createUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUsers(Pageable pageable){
        Map<String, Object> users = getAllUsersService.getAllUsers(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id){
        Map<String, Object> user = getUserByIDService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    @GetMapping("/{email}")
//    public ResponseEntity<Map<String, Object>> getUserByEmail(@PathVariable String email){
//        Map<String, Object> user = getUserByEmailService.getUserByEmail(email);
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id, @RequestBody CreateUserRequestDto updateUserRequestDto){
        Map<String, Object> updatedUser = updateUserService.updateUser(updateUserRequestDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id){
        Map<String, Object> deletedUser = deleteUserService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedUser);
    }

}
