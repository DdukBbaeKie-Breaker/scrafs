package com.scarfs.shortloin.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void authEmail(String email);
    void validEmail(String email, String code);
}
