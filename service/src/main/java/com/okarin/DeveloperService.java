package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.entity.Project;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {

    List<Developer> findAll();

    Optional<Developer> findById(Long developerId);

    Long create(Developer developer);

    Long update(Developer developer);

    void delete(Long developerId);

    List<Developer> findByProjectId(Integer projectId);
}
