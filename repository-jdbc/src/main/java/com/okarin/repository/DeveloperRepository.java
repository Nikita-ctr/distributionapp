package com.okarin.repository;

import com.okarin.entity.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DeveloperRepository extends CrudRepository<Developer,Long> {

    @Query(value = "SELECT * FROM developers order by id",nativeQuery = true)
    List<Developer> findAll();

    @Query(value = "SELECT * FROM developers where projects_id=?1 order by id",nativeQuery = true)
    List<Developer> findByProjectId(Integer projectId);

}
