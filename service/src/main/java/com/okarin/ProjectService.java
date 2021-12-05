package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> findAll();

    Optional<Project> findById(Long projectId);

    Long create(Project project);

    Long update(Project project);

    void delete(Long projectId);



}
