package com.scarfs.shortloin.controller;

import com.scarfs.shortloin.domain.entitys.User;
import com.scarfs.shortloin.domain.paylode.request.UserSignUp;
import com.scarfs.shortloin.service.EmailServiceImpl;
import com.scarfs.shortloin.service.UserServiceImpl;
import com.scarfs.shortloin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired

    UserServiceImpl userService;
    EmailServiceImpl emailService;

    @GetMapping("/authemail")
    public void authEmail(@RequestParam @NotNull String email){
        emailService.authEmail(email);
    }

    @PostMapping("/validemail")
    public void validEmail(@RequestParam String email, String code) {
        emailService.validEmail(email, code);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestParam String userId, String userPw, String userName, Integer number, String email) {

        userService.signUp(
                UserSignUp.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .number(number)
                .email(email)
                .build()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void changeUser(@RequestHeader("Authorization") String token,
                           @RequestParam(required = false) String userPw, String userName ) {

        userService.changeUser(
                User.builder()
                        .uuid(JwtUtil.parseToken(token))
                        .userPw(userPw)
                        .userName(userName)
                        .build()
        );
    }
}
