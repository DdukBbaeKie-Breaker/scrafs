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
    private Integer number;
    private String email;

    @Builder
    public UserSignUp(String userId, String userPw, String userName, Integer number, String email) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.number = number;
        this.email = email;
    }
}
