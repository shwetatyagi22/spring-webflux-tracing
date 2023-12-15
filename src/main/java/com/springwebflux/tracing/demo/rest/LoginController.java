package com.springwebflux.tracing.demo.rest;

import com.springwebflux.tracing.demo.model.AuthReq;
import com.springwebflux.tracing.demo.model.AuthResp;
import com.springwebflux.tracing.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthReq>> login(@RequestBody AuthReq authReq) {
      log.info("Test Login Flow: {}", authReq);
      return userService.findUserByEmail()
          .map(userDetails -> ResponseEntity.ok(new AuthReq(userDetails.getUserName(), userDetails.getPassword())))
          .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
  }