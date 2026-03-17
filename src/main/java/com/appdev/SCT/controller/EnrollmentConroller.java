package com.appdev.SCT.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.User;
import com.appdev.SCT.service.UserService;
import com.appdev.SCT.service.CourseService;
import com.appdev.SCT.service.SpEnrollmentService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnrollmentConroller {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private CourseService CourseService;
	
	@Autowired
	private SpEnrollmentService SpEnrollmentService;
	
	@PostMapping("/api/enrollment")
	public String enrollmentLoad(@RequestParam int id, Model model ) {
		
		
		
		List<Map<String, Object>> subject =
				SpEnrollmentService.runSPEnrollment(null, "", "", 1, "");
		

		
		model.addAttribute("subject",subject);
		return "LoadEnrollment";
	}
	@GetMapping("/enrollment")
	public String enrollment(HttpSession session, Model model) {
		String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
		if (studentId != null) {
		    User user = userService.findBystudentid(studentId); // Fetch user from database
		    
		    List<Course> course = CourseService.findAll();
		    
		    model.addAttribute("user", user);
		    model.addAttribute("course", course);
		    
		    return "enrollment";
		} else {
		    return "redirect:/login";
		}
	}
}
