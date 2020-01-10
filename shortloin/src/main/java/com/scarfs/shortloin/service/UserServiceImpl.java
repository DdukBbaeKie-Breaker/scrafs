package com.scarfs.shortloin.service;

import com.scarfs.shortloin.domain.entitys.User;
import com.scarfs.shortloin.domain.repository.UserRepository;
import com.scarfs.shortloin.exception.UserAlreadyExistsException;
import com.scarfs.shortloin.domain.paylode.request.UserSignUp;
import com.scarfs.shortloin.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void signUp(UserSignUp userSignUp) {
        if(userRepository.existsByUserId(userSignUp.getUserId())) throw new UserAlreadyExistsException();

        userRepository.save(
                User.builder()
                .userId(userSignUp.getUserId())
                .userPw(userSignUp.getUserPw())
                .userName(userSignUp.getUserName())
                .number(userSignUp.getNumber())
                .email(userSignUp.getEmail())
                .build()
        );
    }

    @Override
    public void changeUser(User info) {
        User user = userRepository.findByUuid(info.getUuid());
        if(user == null) throw new UserNotFoundException();

        if(info.getUserPw() != null) user.setUserPw(info.getUserPw());
        if(info.getUserName() != null) user.setUserName(info.getUserName());

        userRepository.save(user);
    }
}
