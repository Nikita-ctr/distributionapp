package com.okarin.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@EntityScan(basePackages = "com.okarin")
@EnableJpaRepositories(basePackages = "com.okarin")
public class TestConfig {
}
