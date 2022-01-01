package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import com.okarin.repository.DeveloperRepository;
import com.okarin.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ProjectDaoJdbc.class, DeveloperDaoJdbc.class})
@ActiveProfiles("test")
public class MockDaoJdbcTest {

    @MockBean
    ProjectRepository projectRepository;

    @MockBean
    DeveloperRepository developerRepository;

    @Autowired
    DeveloperDao developerDao;

    @Autowired
    ProjectDao projectDao;

    @Test
    void findByIdShouldBeEmpty() {
        Assertions.assertFalse(projectDao.findById((long)0).isPresent());
        Assertions.assertFalse(developerDao.findById((long)0).isPresent());
    }

    @Test
    void createShouldReturnIdZero() {
        when(projectRepository.save(any())).thenReturn(new Project());
        when(developerRepository.save(any())).thenReturn(new Developer());

        Assertions.assertNull(projectDao.create(any()));
        Assertions.assertNull(developerDao.create(any()));
    }
    //todo
        @Test
        void updateShouldReturnAValue() {
            when(projectRepository.save(any())).thenReturn(new Project(""));
            when(projectRepository.findById(any())).thenReturn(Optional.of(new Project("")));
            when(developerRepository.save(any())).thenReturn(new Developer( "Name", "LastName", new Date(1), 11,1));
            when(developerRepository.findById(any())).thenReturn(Optional.of(new Developer( "Name", "LastName", new Date(1), 11,1)));

            Assertions.assertNotNull(developerDao.update(new Developer("Name", "LastName", new Date(1), 11,1)));



        }
    @Test
    void deleteShouldExecute() {
        when(projectRepository.findById(any())).thenReturn(Optional.of(new Project("")));
        when(developerRepository.findById(any())).thenReturn(Optional.of(new Developer(1L, "Name", "LastName", new Date(), 11,1)));

        Assertions.assertDoesNotThrow(() -> projectDao.delete((long)1));
        Assertions.assertDoesNotThrow(() -> developerDao.delete((long)1));
    }

    @Test
    void findByDepartmentIdShould(){
        Assertions.assertNotNull(developerDao.findByProjectId(1L));
    }
    }

