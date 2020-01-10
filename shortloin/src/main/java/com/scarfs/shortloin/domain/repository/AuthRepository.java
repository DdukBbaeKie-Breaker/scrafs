package com.scarfs.shortloin.domain.repository;

import com.scarfs.shortloin.domain.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {
    User findByUserIdAndUserPw(String userId, String userPw);
    User findByUuidAndRefreshToken(int uuid, String refreshToken);

}
