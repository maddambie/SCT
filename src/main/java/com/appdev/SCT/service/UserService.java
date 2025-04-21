package com.appdev.SCT.service;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdev.SCT.model.User;
import com.appdev.SCT.repository.UserRepository;


@Service
public class UserService {


    @Autowired
    private UserRepository UserRepository;

    public void save(User user) {
        UserRepository.save(user); 
    }
    
    public void findAll(User user) {
    	UserRepository.findAll();
    }
    
    public User findBystudentid(String studentid) {
        return UserRepository.findBystudentid(studentid); // Fetch user from database
    }
   public User findUsersByStudentidAndPassword(String studentid, String password) {
        return UserRepository.findUsersByStudentidAndPassword(studentid, password);
    }
    	
}
