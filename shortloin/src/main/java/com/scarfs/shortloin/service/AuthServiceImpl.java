package com.scarfs.shortloin.service;

import com.scarfs.shortloin.domain.entitys.User;
import com.scarfs.shortloin.domain.paylode.response.TokenResponse;
import com.scarfs.shortloin.domain.repository.AuthRepository;
import com.scarfs.shortloin.exception.InvalidTokenException;
import com.scarfs.shortloin.exception.UserNotFoundException;
import com.scarfs.shortloin.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    public AuthServiceImpl(AuthRepository authRepository) {

        this.authRepository = authRepository;
    }

    @Override
    public TokenResponse login(String userId, String userPw) {
        User user = authRepository.findByUserIdAndUserPw(userId, userPw);
        if(user == null) throw new UserNotFoundException();

        TokenResponse token = new TokenResponse(user.getUuid());
        user.setRefreshToken(token.getRefreshToken());
        authRepository.save(user);
        return token;
    }

    @Override
    public TokenResponse refreshToken(String token) {
        int uuid = JwtUtil.parseToken(token);
        User user = authRepository.findByUuidAndRefreshToken(uuid, token);
        if(user == null || !user.getRefreshToken().equals(token)) throw new InvalidTokenException();

        return new TokenResponse(token);
    }
}
