package com.yojana.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yojana.entities.Project;
import com.yojana.repos.ProjectRepository;
@Service
@Transactional
public class ProjectService {
 
    @Autowired
    private ProjectRepository repo;
    
    public List<Project> listAll() {
        return repo.findAll();
    }
    public void deleteProjectTasks(Integer id) {
    	repo.deleteProjectTasks(id);
    }
     
    public void save(Project proj) {
        repo.save(proj);
    }
     
    public Project get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}