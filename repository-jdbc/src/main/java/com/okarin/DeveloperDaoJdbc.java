package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeveloperDaoJdbc implements DeveloperDao {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperDaoJdbc(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    @Override
    public Optional<Developer> findById(Long developerId) {
        return developerRepository.findById(developerId);
    }

    @Override
    public Long create(Developer developer) {
        return developerRepository.save(developer).getId();
    }

    @Override
    public Long update(Developer developer) {
        Developer oldDeveloper=developerRepository.findById(developer.getId()).get();
        oldDeveloper.cloneData(developer);
        return developerRepository.save(oldDeveloper).getId();

    }

    @Override
    public void delete(Long developerId) {
        developerRepository.deleteById(developerId);
    }

    @Override
    public List<Developer> findByDeveloperId(Integer developerId) {
        return developerRepository.findByProjectId(developerId);
    }
}