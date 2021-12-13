package com.okarin.conf;

import com.okarin.DeveloperDao;
import com.okarin.DeveloperDaoJdbc;
import com.okarin.ProjectDao;
import com.okarin.ProjectDaoJdbc;
import com.okarin.repository.DeveloperRepository;
import com.okarin.repository.ProjectRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockTestConfig {


    @MockBean
    ProjectRepository projectRepository;

    @Bean
    ProjectDao projectDao(){
        return new ProjectDaoJdbc();
    }
    @MockBean
    DeveloperRepository developerRepository;

    @Bean
    DeveloperDao developerDao(){
        return new DeveloperDaoJdbc();
    }
}
