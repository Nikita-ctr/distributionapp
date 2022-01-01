package com.okarin;

import com.okarin.conf.TestConfig;
import com.okarin.entity.Project;
import com.okarin.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

@DataJpaTest
@ContextConfiguration(classes = {TestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@ActiveProfiles(profiles = "test")
public class ProjectRepoTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void findAllShouldReturnInitiatedEntities(){
        Assertions.assertFalse(projectRepository.findAll().isEmpty());
    }
    @Test
    void findByIdShouldReturnInitiatedEntities() {
        Project project=projectRepository.findAll().get(0);
        Assertions.assertEquals(Optional.of(project), projectRepository.findById(project.getId()));
        project = projectRepository.findAll().get(1 );
        Assertions.assertEquals(Optional.of(project), projectRepository.findById(project.getId()));
    }
@Test
    void createShouldAddNewEntity(){
        long size=projectRepository.count();
        projectRepository.save(new Project("A"));
        Assertions.assertEquals(size+1,projectRepository.findAll().size());
}
@Test
    void countShouldBeEqualsToTestInitiateSet(){
        Assertions.assertEquals(projectRepository.findAll().size(),projectRepository.count());
}
}
