package com.scarfs.shortloin.service;

import com.scarfs.shortloin.domain.paylode.response.TokenResponse;

public interface AuthService {
    TokenResponse login(String userId, String userPw);
    TokenResponse refreshToken(String token);
}
