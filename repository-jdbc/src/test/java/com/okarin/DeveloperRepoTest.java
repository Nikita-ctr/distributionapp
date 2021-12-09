package com.okarin;

import com.okarin.conf.TestConfig;
import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import com.okarin.repository.DeveloperRepository;
import com.okarin.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = {TestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@ActiveProfiles(profiles = "test")
public class DeveloperRepoTest {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    DeveloperRepository developerRepository;

    @Test
    void findAllShouldReturnInitiatedEntities() {
        Assertions.assertFalse(developerRepository.findAll().isEmpty());
    }

    @Test
    void findByIdShouldReturnInitiatedEntities() {
        Developer developer=developerRepository.findAll().get(0);
        Assertions.assertEquals(Optional.of(developer), developerRepository.findById(developer.getId()));
        developer = developerRepository.findAll().get(1);
        Assertions.assertEquals(Optional.of(developer), developerRepository.findById(developer.getId()));
    }
    @Test
    void deleteShouldDeleteAllEntitiesOneByOneInCycleAndDatabaseBeEmpty() {
        for(Developer developer : developerRepository.findAll())
           developerRepository.delete(developer);
        for(Project project : projectRepository.findAll())
            projectRepository.delete(project);
        Assertions.assertTrue(projectRepository.findAll().isEmpty());
        Assertions.assertTrue(developerRepository.findAll().isEmpty());
    }

}
