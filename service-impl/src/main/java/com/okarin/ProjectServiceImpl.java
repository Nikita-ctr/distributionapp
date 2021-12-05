package com.okarin;

import com.okarin.entity.Developer;
import com.okarin.entity.Project;
import com.okarin.exceptions.ProjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public List<Project> findAll() {
       return projectDao.findAll();
    }

    public Optional<Project> findById(Long projectId) {
        if (projectDao.findById(projectId).isPresent())
            return projectDao.findById(projectId);
        else throw new ProjectNotFoundExeption(projectId);
    }

    public Long create(Project project) {
        return projectDao.create(project);
    }

    public Long update(Project project) {
        findById(project.getId());
        return projectDao.update(project);
    }

    public void delete(Long projectId) {
        projectDao.delete(findById(projectId).get().getId());
    }

}
