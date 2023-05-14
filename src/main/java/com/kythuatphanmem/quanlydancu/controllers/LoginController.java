package com.kythuatphanmem.quanlydancu.controllers;

import com.kythuatphanmem.quanlydancu.models.MyUser;
import com.kythuatphanmem.quanlydancu.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody MyUser user) {
        MyUser savedUser = null;
        ResponseEntity response = null;

        try {
            String hashPwd = passwordEncoder.encode(user.getPwd());
            user.setPwd(hashPwd);
            savedUser = userRepository.save(user);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + ex.getMessage());
        }
        return response;
    }

    @GetMapping("/api/user")
    public MyUser getUserDetailsAfterLogin(Authentication authentication) {
        List<MyUser> users = userRepository.findByEmail(authentication.getName());
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }
}
