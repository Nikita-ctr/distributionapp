package com.okarin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.okarin")
@EnableJpaRepositories("com.okarin")
public class RestAppConfig {
}