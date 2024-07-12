package com.NestBlog.Controller;

import com.NestBlog.Payload.Signup;
import com.NestBlog.entity.User;
import com.NestBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    //http://localhost:8080/api/auth/sign-up
    @PostMapping("/sign-up")
    public ResponseEntity<String> createUser(@RequestBody Signup signup){
        if(userRepository.existsByEmail(signup.getEmail())){
            return new ResponseEntity<>("email id is already registered", HttpStatus.CREATED);
        }

        if (userRepository.existsByUsername(signup.getUsername())){
            return new ResponseEntity<>("username is already registered",HttpStatus.CREATED);
        }

        User user = new User();
        user.setName(signup.getName());
        user.setEmail(signup.getEmail());
        user.setUsername(signup.getUsername());
        user.setPassword(signup.getPassword());

        userRepository.save(user);

        return new ResponseEntity<>("user registered", HttpStatus.CREATED);
    }
}
