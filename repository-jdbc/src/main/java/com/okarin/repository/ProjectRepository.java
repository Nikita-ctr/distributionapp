package com.okarin.repository;

import com.okarin.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectRepository extends CrudRepository<Project,Long> {


    @Query(value = "SELECT * FROM project order by id",nativeQuery = true)
    List<Project> findAll();

}
