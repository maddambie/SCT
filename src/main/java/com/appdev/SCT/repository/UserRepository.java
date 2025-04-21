package com.appdev.SCT.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.appdev.SCT.model.User;

@Controller
public interface UserRepository  extends JpaRepository<User, Long> {
	User findUsersByStudentidAndPassword(String studentid, String password);
	User findBystudentid(String studentid);
}

