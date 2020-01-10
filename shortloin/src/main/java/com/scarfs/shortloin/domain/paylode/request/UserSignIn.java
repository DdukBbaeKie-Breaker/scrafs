package com.scarfs.shortloin.domain.paylode.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignIn {
    private String userId;
    private String userPw;

    @Builder
    public UserSignIn(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
}
