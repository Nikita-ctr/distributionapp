package com.okarin;

import com.okarin.entity.Project;
import com.okarin.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectDaoJdbc implements ProjectDao{

    @Autowired
     ProjectRepository projectRepository;


    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long projectId) {
        return projectRepository.findById(projectId);

    }

    public Long create(Project project) {
        return projectRepository.save(project).getId();
    }

    public Long update(Project project) {
        Project oldProject=projectRepository.findById(project.getId()).get();
        oldProject.cloneData(project);
        return projectRepository.save(oldProject).getId();
    }

    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
