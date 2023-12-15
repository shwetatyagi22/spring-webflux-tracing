package com.springwebflux.tracing.demo.service;

import com.springwebflux.tracing.demo.model.AuthReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {
    public Mono<AuthReq> findUserByEmail() {
        log.info("I am in user service");
        AuthReq authReq = new AuthReq();
        authReq.setUserName("test");
        authReq.setPassword("1234");
        return  Mono.justOrEmpty( authReq );
    }

}
