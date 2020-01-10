package com.scarfs.shortloin.service;

import com.scarfs.shortloin.domain.entitys.User;
import com.scarfs.shortloin.domain.paylode.request.UserSignUp;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void signUp(UserSignUp userSignUp);
    void changeUser(User user);
}
