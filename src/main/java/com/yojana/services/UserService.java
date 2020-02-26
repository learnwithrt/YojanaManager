package com.yojana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yojana.entities.User;
import com.yojana.repos.UserRepository;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
    public int loginUser(String id,String pass) {
    	return repo.loginUser(id, pass);
    }
    public List<User> listAll() {
        return repo.findAll();
    }
     
    public void save(User User) {
        repo.save(User);
    }
     
    public User get(String id) {
        return repo.findById(id).get();
    }
     
    public void delete(String id) {
        repo.deleteById(id);
    }
    
}