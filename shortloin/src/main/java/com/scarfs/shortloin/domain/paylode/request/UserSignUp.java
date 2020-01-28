package com.scarfs.shortloin.domain.paylode.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUp {
    private String userId;
    private String userPw;
    private String userName;
    private Integer userNumber;
    private String email;
    private String authCode;

    @Builder
    public UserSignUp(String userId, String userPw, String userName, Integer userNumber, String email, String authCode) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userNumber = userNumber;
        this.email = email;
        this.authCode = authCode;
    }
}
