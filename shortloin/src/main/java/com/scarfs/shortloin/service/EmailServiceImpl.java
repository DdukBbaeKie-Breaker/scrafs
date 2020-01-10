package com.scarfs.shortloin.service;

import com.scarfs.shortloin.domain.entitys.EmailAuth;
import com.scarfs.shortloin.domain.repository.AuthEmailRepository;
import com.scarfs.shortloin.exception.UserNotFoundException;
import com.scarfs.shortloin.util.EmailUtil;

public class EmailServiceImpl implements EmailService {

    private AuthEmailRepository authEmailRepository;

    public EmailServiceImpl(AuthEmailRepository authEmailRepository) {

        this.authEmailRepository = authEmailRepository;
    }

    @Override
    public void authEmail(String email) {
        String uuid = randomCode();
        authEmailRepository.save(
                EmailAuth.builder()
                .authEmail(email)
                .authCode(uuid)
                .authState("UnAuthorized")
                .build()
        );
        EmailUtil.sendMail(email, uuid);
        new Thread(() -> {
           try {
               Thread.sleep(300000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           EmailAuth emailAuth = authEmailRepository.findByAuthEmail(email);
           authEmailRepository.delete(emailAuth);
        });
    }

    @Override
    public void validEmail(String email, String code) {
        EmailAuth auth = authEmailRepository.findByAuthEmailAndAuthCode(email, code);
        if(auth == null) throw new UserNotFoundException();

        auth.setAuthState("Authorized");
        authEmailRepository.save(auth);
    }

    private String randomCode() {
        StringBuilder code = new StringBuilder();
        String[] codeList = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        int random;
        for (int i = 0; i < 6; i++) {
            random = (int) (Math.random() * codeList.length);
            code.append(codeList[random]);
        }
        return code.toString();
    }
}
