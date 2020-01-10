package com.scarfs.shortloin.domain.entitys;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uuid;

    @Column(length = 30)
    private String userId;

    @Column
    private String userPw;

    @Column
    private String userName;

    @Column
    private Integer number;

    @Column
    private String email;

    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    @Builder
    public User(Integer uuid, String userId, String userPw, String userName, String email, Integer number, String refreshToken) {
        this.uuid = uuid;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.number = number;
        this.email = email;
        this.refreshToken =refreshToken;
    }


}
