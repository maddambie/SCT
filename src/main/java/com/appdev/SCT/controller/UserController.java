package com.appdev.SCT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appdev.SCT.model.Teacher;
import com.appdev.SCT.service.TeacherService;
import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.User;
import com.appdev.SCT.repository.CourseRepository;
import com.appdev.SCT.repository.UserRepository;
import com.appdev.SCT.service.CourseService;
import com.appdev.SCT.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
			
			@Autowired
			private UserRepository UserRepository;
			@Autowired
			private CourseRepository CourseRepository;
			
			
			@GetMapping("/")
				public String showWelcomePage(HttpSession session, Model model) {
			    	User user = (User) session.getAttribute("studentid");
			        if (user != null) {
			            model.addAttribute("user", user);
			            return "welcome";  // Return the welcome page
			        } else {
			            return "redirect:/login";  // Redirect if session is missing	
			        }
			}
		
			
			@GetMapping("/welcome")
			public String WelcomePage(HttpSession session, Model model) {
				String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (studentId != null) {
				    User user = userService.findBystudentid(studentId); // Fetch user from database
				    model.addAttribute("user", user);
				    return "welcome";
				} else {
				    return "redirect:/login";
				}
		}
			
			
			@GetMapping("/courses")
			public String courses(HttpSession session, Model model) {
				String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (studentId != null) {
				    User user = userService.findBystudentid(studentId); // Fetch user from database
				    List<Course> courses = CourseRepository.findAll();
				    model.addAttribute("courses", courses);
				    
				    model.addAttribute("user", user);
				    return "courses";
				} else {
				    return "redirect:/login";
				}
		}
			
			
			@GetMapping("/account")
			public String account(HttpSession session, Model model) {
				String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (studentId != null) {
				    User user = userService.findBystudentid(studentId); // Fetch user from database
				    model.addAttribute("user", user);
				    return "account";
				} else {
				    return "redirect:/login";
				}
		}



		    
		    @GetMapping("/login")
		    public String showloginForm(Model model) {
		        model.addAttribute("user", new User());
		        return "login";
		    }
		    
		    /*@PostMapping("/login")
		    public String validateUser(@RequestParam("email") String email, 
		                               @RequestParam("password") String password, 
		                               Model model) {
		        
		        model.addAttribute("email", email);
		        model.addAttribute("password", password);

		      
		        return "login";  
		        
		    }*/

		    @Autowired
		    private UserService userService;
		    
		    @GetMapping("/register")
		    public String showStudentRegistrationForm(Model model) {
		        model.addAttribute("user", new User());
		        return "registration";
		    }

		    @GetMapping("/index")
		    public String index() {
		        return "index";
		    }
		    
		    @GetMapping("/teacherlogin")
		    public String teacher() {
		        return "teacherlogin";
		    }
		    @GetMapping("/adminlogin")
		    public String admin() {
		        return "adminlogin";
		    }
		    
		    
		    
		    @PostMapping("/register")
		    public String registration(@ModelAttribute("user") User user) {
		        userService.save(user);
		        return "redirect:/success";
		    }
		    
		    //teacher
		    @Autowired
		    private TeacherService teacherService;

		    @GetMapping("/teacherReg")
		    public String showTeacherRegistrationForm(Model model) {
		        model.addAttribute("teacher", new Teacher());
		        return "teacherReg";
		    }

		    @PostMapping("/teacherReg")
		    public String registerTeacher(@ModelAttribute("teacher") Teacher teacher) {
		        teacherService.registerTeacher(teacher);
		        return "redirect:/success";
		    }
		    
		    
		   

		    // Method for registering a new user (POST request)

		   
		    
		    @PostMapping("/user/save")
		    public String handleForm(@RequestParam String studentid, @RequestParam String email,@RequestParam String department,@RequestParam String yearlevel, @RequestParam String studentName, @RequestParam String password, @RequestParam String program, Model model) {
		    	{
		    		model.addAttribute("message", "Success");
		    	}
		        model.addAttribute("studentid", studentid);
		        model.addAttribute("studentName", studentName);
		        model.addAttribute("email", email);
		        model.addAttribute("department", department);
		        model.addAttribute("yearlevel", yearlevel);
		        model.addAttribute("password", password);
		        model.addAttribute("program", program);
		        try {
		        	
		        	User user = new User(studentid, studentName, email,department,yearlevel, password, program);
		        	UserRepository.save(user);
			       
		            return "success";
		        }
		        catch(Exception e) {
		        	model.addAttribute("error", "Error: " + e.getMessage());
		            return "/registration";
		        }
		        
		       // return "success";
		    }	

	
		    @PostMapping("ChangePassword")
		    public String changePassword(@RequestParam String currentPassword,
		                                 @RequestParam String newPassword,
		                                 @RequestParam String confirmPassword,
		                                 HttpSession session,
		                                 Model model, RedirectAttributes redirectAttributes) {
		    	String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (studentId != null) {
					User user = userService.findBystudentid(studentId);

			        user.setPassword((newPassword));
			        userService.save(user);
			        redirectAttributes.addFlashAttribute("message", "Password changed successfully.");
			        model.addAttribute("user", user);
			        return "redirect:/account";
				} else {
				    return "redirect:/login";
				}
		        
		        
		    }
		   
		    
	    
		    @PostMapping("/loginval")
		    public String loginUser(@RequestParam String studentid, @RequestParam String password, Model model,  HttpSession session) {
		        User user = userService.findUsersByStudentidAndPassword(studentid, password);

		        if (user != null) {
		            // If login is successful, redirect to dashboard page
		            model.addAttribute("user", user);
		            session.setAttribute("loggedInUser", user.getFullname());
		            session.setAttribute("studentid", user.getStudentid());
		            return "redirect:/welcome";  //
		        } else {
		            // If login fails, return to login page with error message
		            model.addAttribute("error", "Wrong Credential.");
		            return "/login";
		        }
		    }
	}

		
		
