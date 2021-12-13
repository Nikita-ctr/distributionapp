package com.okarin;

import com.okarin.entity.Developer;

import java.util.List;
import java.util.Optional;

public interface DeveloperDao {


    List<Developer> findAll();

    Optional<Developer> findById(Long developerId);

    Long create(Developer developer);

    Long update(Developer developer);

    void delete(Long developerId);

    List<Developer> findByDeveloperId(Integer developerId);
    //Long count();

}
