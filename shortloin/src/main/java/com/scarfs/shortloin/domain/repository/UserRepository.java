package com.scarfs.shortloin.domain.repository;

import com.scarfs.shortloin.domain.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserId(String userId);
    User findByUuid(Integer uuid);
}
