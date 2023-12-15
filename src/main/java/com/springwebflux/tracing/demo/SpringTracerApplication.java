package com.springwebflux.tracing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import reactor.core.publisher.Hooks;


@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class,
		ReactiveManagementWebSecurityAutoConfiguration.class,
		ReactiveUserDetailsServiceAutoConfiguration.class})
public class SpringTracerApplication {
	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(SpringTracerApplication.class, args);
	}
}
