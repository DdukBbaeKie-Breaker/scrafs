package com.scarfs.shortloin.domain.repository;

import com.scarfs.shortloin.domain.entitys.EmailAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthEmailRepository extends JpaRepository<EmailAuth, Object> {
    EmailAuth findByAuthEmail(String mail);
    EmailAuth findByAuthEmailAndAuthCode(String email, String  code);
}
