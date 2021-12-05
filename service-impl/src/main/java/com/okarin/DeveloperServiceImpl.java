package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.exceptions.DeveloperNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperDao developerDao;

    @Autowired
    ProjectService projectService;

    @Autowired
    public DeveloperServiceImpl(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @Override
    public List<Developer> findAll() {
        return developerDao.findAll();
    }

    @Override
    public Optional<Developer> findById(Long developerId) {
        if (developerDao.findById(developerId).isPresent())
            return developerDao.findById(developerId);
        else throw new DeveloperNotFoundExeption(developerId);
    }

    @Override
    public Long create(Developer developer) {
        projectService.findById(developer.getId());
        return developerDao.create(developer);
            }

    @Override
    public Long update(Developer developer) {
        findById(developer.getId());
        return developerDao.update(developer);
    }

    @Override
    public void delete(Long developerId) {
        developerDao.delete(findById(developerId).get().getId());

    }

    @Override
    public List<Developer> findByProjectId(Integer projectId) {
        return developerDao.findByDeveloperId(projectId);
    }

}
