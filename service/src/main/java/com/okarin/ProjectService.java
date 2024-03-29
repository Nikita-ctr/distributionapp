package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface ProjectService {


    List<Project> findAll();

    Optional<Project> findById(Long projectId);

    Long create(Project project);

    Long update(Project project);

    void delete(Long projectId);

}
