package com.okarin;

import com.okarin.conf.MockTestConfig;
import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import com.okarin.exceptions.DeveloperNotFoundExeption;
import com.okarin.exceptions.ProjectNotFoundExeption;
import com.okarin.repository.DeveloperRepository;
import com.okarin.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DeveloperServiceImpl.class,ProjectServiceImpl.class})
@ContextConfiguration(classes = MockTestConfig.class)
@ActiveProfiles("test")
public class DeveloperServiceImplMockTest {

    @Autowired
    ProjectRepository projectRepository;


    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    DeveloperService developerService;

    @Test
    void findAllShouldReturnEmptyList() {
        Assertions.assertNotNull(developerService.findAll());

    }

    @Test
    void findByIdShouldThrowDeveloperNotFoundException() {
        Assertions.assertThrows(DeveloperNotFoundExeption.class, () -> developerService.findById((long) 1));
    }

    //todo fix

    @Test
    void createShouldProcessButEntityListEmpty() {
        Assertions.assertThrows(ProjectNotFoundExeption.class, () -> developerService.create(new Developer(1L, "Name", "LastName", new Date(), 11,new Project(1L,"Giti"))));
        Assertions.assertThrows(DeveloperNotFoundExeption.class, () -> developerService.findById((long) 0));

        when(projectRepository.findById(any())).thenReturn(Optional.of(new Project(1L,"")));
        when(developerRepository.save(any())).thenReturn(new Developer(1L, "Name", "LastName", new Date(), 11,new Project()));
        Assertions.assertDoesNotThrow(() -> developerService.create(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));
    }

    @Test
    void updateShouldThrowDeveloperNotFoundExceptionButNotWhenMocked() {
        Assertions.assertThrows(DeveloperNotFoundExeption.class, () -> developerService.update(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));

        when(developerRepository.save(any())).thenReturn(new Developer(1L, "Name", "LastName", new Date(), 11,new Project()));
        when(developerRepository.findById(any())).thenReturn(Optional.of(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));
        Assertions.assertNotNull(developerService.update(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));
    }

    @Test
    void deleteShouldThrowDeveloperNotFoundExceptionButNotWhenMocked() {
        Assertions.assertThrows(DeveloperNotFoundExeption.class, () -> developerService.delete(Mockito.anyLong()));

        when(developerRepository.findById(any())).thenReturn(Optional.of(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));
        when(developerRepository.findById(any())).thenReturn(Optional.of(new Developer(1L, "Name", "LastName", new Date(), 11,new Project())));
        Assertions.assertDoesNotThrow(() -> developerService.delete((long) 1));
    }


    @Test
    void findByProjectIdShouldReturnInstance() {
        when(developerRepository.findByProjectId(anyLong())).thenReturn(new ArrayList<>());
        Assertions.assertTrue(developerService.findByProjectId(1L).isEmpty());

    }
}
