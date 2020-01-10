package com.scarfs.shortloin.domain.paylode.response;

import com.scarfs.shortloin.util.JwtUtil;
import lombok.Getter;

@Getter
public class TokenResponse {
    private String accessToken;
    private String refreshToken;

    public TokenResponse(Object data) {
        this.accessToken = JwtUtil.getAccessToken(data);
        this.refreshToken = JwtUtil.getRefreshToken(data);
    }
}
