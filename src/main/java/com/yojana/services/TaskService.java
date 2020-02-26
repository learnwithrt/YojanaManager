package com.yojana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojana.entities.Task;

import com.yojana.repos.TaskRepository;
 
@Service
@Transactional
public class TaskService {
 
    @Autowired
    private TaskRepository repo;
    public List<Task> getInfo(Integer id){
    	return repo.getInfo(id);
    }
    public List<Task> listAll() {
        return repo.findAll();
    }
    public void deleteTasks(Integer id) {
    	repo.deleteTasks(id);
    }
    public void save(Task task) {
        repo.save(task);
    }
     
    public Task get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
}