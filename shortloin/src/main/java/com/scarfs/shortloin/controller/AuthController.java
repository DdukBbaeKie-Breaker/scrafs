package com.scarfs.shortloin.controller;

import com.scarfs.shortloin.domain.paylode.request.UserSignIn;
import com.scarfs.shortloin.domain.paylode.response.TokenResponse;
import com.scarfs.shortloin.service.AuthService;
import com.scarfs.shortloin.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signIn(@RequestBody @NotNull UserSignIn userSignIn) {
        return authService.login(userSignIn.getUserId(), userSignIn.getUserPw());
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("Authorization") String refreshToken) {
        return authService.refreshToken(refreshToken);
    }
}
