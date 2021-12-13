package com.okarin;

import com.okarin.conf.MockTestConfig;
import com.okarin.entity.Project;
import com.okarin.exceptions.ProjectNotFoundExeption;
import com.okarin.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes = ProjectServiceImpl.class)
@ContextConfiguration(classes = MockTestConfig.class)
@ActiveProfiles("test")
public class ProjectServiceImplMockTest {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectService projectService;

    @Test
    void findAllShouldReturnEmptyList() {
        Assertions.assertNotNull(projectService.findAll());
    }

    @Test
    void findByIdShouldThrowProjectNotFoundException() {
        Assertions.assertThrows(ProjectNotFoundExeption.class,() -> projectService.findById((long)1));
    }

    @Test
    void createShouldProcessButEntityListEmpty() {
        when(projectRepository.save(any())).thenReturn(new Project("XZx"));

        Assertions.assertNull(projectService.create(Mockito.any()));
        Assertions.assertThrows(ProjectNotFoundExeption.class,() -> projectService.findById((long)0));
    }

    @Test
    void updateShouldThrowDepartmentNotFoundExceptionButNotWhenMocked() {
        Assertions.assertThrows(ProjectNotFoundExeption.class, () ->projectService.update(new Project("Giti")));

        when(projectRepository.save(any())).thenReturn(new Project(""));
        when(projectRepository.findById(any())).thenReturn(Optional.of(new Project("")));
        Assertions.assertNotNull(projectService.update(new Project("")));
    }

    @Test
    void deleteShouldThrowDepartmentNotFoundExceptionButNotWhenMocked() {
        Assertions.assertThrows(ProjectNotFoundExeption.class, () -> projectService.delete(Mockito.anyLong()));

        when(projectRepository.findById(any())).thenReturn(Optional.of(new Project("")));
        Assertions.assertDoesNotThrow(() -> projectService.delete((long)1));
    }

        }
