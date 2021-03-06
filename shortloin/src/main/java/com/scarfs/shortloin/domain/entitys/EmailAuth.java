package com.scarfs.shortloin.domain.entitys;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class EmailAuth {

    @Id
    @Column(length = 30)
    private String authEmail;

    @Column(nullable = false, length = 36)
    private String authCode;

    @Column
    private String authState;

    @Builder
    public EmailAuth(String authEmail , String authCode, String authState) {
        this.authEmail = authEmail;
        this.authCode = authCode;
        this.authState = authState;
    }
}
