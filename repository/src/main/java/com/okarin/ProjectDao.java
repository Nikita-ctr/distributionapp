package com.okarin;

import com.okarin.entity.Project;


import java.util.List;
import java.util.Optional;

public interface ProjectDao {


    List<Project> findAll();

    Optional<Project> findById(Long projectId);

    Long create (Project project);

    Long update(Project project);

    void delete(Long projectId);

    //Long count();
}
