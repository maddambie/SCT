package com.appdev.SCT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.appdev.SCT.model.Teacher;
import com.appdev.SCT.service.TeacherService;
import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.User;
import com.appdev.SCT.repository.CourseRepository;
import com.appdev.SCT.repository.TeacherRepository;
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
			@Autowired
			private TeacherRepository teacherRepository;
			
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
			
		    @GetMapping("/teacher/dash")
		    public String teacherHome(HttpSession session, Model model) {
				String teacherId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (teacherId != null) {
				    Teacher teacher = teacherService.findByteacherId(teacherId); // Fetch user from database
				    model.addAttribute("teacher", teacher);
				    return "teacherdash";
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



		    
			@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
		    public String showloginForm(@RequestParam(required = false) String hiddenValue, Model model) {
		        model.addAttribute("user", new User());
		       
		        if(hiddenValue == null || hiddenValue.trim().isEmpty()) {
		        	hiddenValue = "Student";
		        }
		        model.addAttribute("hiddenValue", hiddenValue);		
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
		    
		    @GetMapping("/register/Student")
		    public String showStudentRegistrationForm(Model model) {
		        model.addAttribute("user", new User());
		        return "registration";
		    }

		    @GetMapping("/index")
		    public String index() {
		        return "index";
		    }
		    
		    @Autowired
		    private TeacherService teacherService;

		    @GetMapping("/register/Teacher")
		    public String showTeacherRegistrationForm(Model model) {
		        model.addAttribute("teacher", new Teacher());
		        return "teacherReg";
		    }
		    
		    @PostMapping("/teacher/save")
		    public String handleForm(@RequestParam String teacherId, @RequestParam String fullN,@RequestParam String email,@RequestParam String phone, @RequestParam String department, @RequestParam String facultyId, @RequestParam String password, @RequestParam String eduBack, @RequestParam int experience, Model model) {
		    	{
		    		model.addAttribute("message", "Success");
		    	}
		        model.addAttribute("teacherId", teacherId);
		        model.addAttribute("fullN", fullN);
		        model.addAttribute("email", email);
		        model.addAttribute("phone", phone);
		        model.addAttribute("department", department);
		        model.addAttribute("facultyId", facultyId);
		        model.addAttribute("password", password);
		        model.addAttribute("eduBack", eduBack);
		        model.addAttribute("experience", experience);
		        try {
		        	
		        	Teacher teacher = new Teacher(teacherId, fullN, phone, email, department, facultyId, password, eduBack, experience);
		        	teacherRepository.save(teacher);
			       
		            return "success";
		        }
		        catch(Exception e) {
		        	model.addAttribute("error", "Error: " + e.getMessage());
		            return "/teacherReg";
		        }
		        
		    }	
		    

		    
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
		   
		    
	    
		    @PostMapping("/login/Student")
		    public String loginUser(@RequestParam String studentid, @RequestParam String password,@RequestParam String hiddenValue, Model model,  HttpSession session) {
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
		            model.addAttribute("hiddenValue", hiddenValue);
		            return "/login";
		        }
		    }
		    
		    @PostMapping("/login/Teacher")
		    public String loginTeacher(@RequestParam String studentid, @RequestParam String password,@RequestParam String hiddenValue, Model model,  HttpSession session) {
		        Teacher teacher = teacherService.findByTeacherIdAndPassword(studentid, password);

		        if (teacher != null) {
		            // If login is successful, redirect to dashboard page
		            model.addAttribute("teacher", teacher);
		            session.setAttribute("loggedInUser", teacher.getFullName());
		            session.setAttribute("studentid", teacher.getteacherId());
		            return "redirect:/teacher/dash";  //
		        } else {
		            // If login fails, return to login page with error message
		            model.addAttribute("error", "Wrong Credential.");
		            model.addAttribute("hiddenValue", hiddenValue);
		            return "/login";
		        }
		    }
		    
	}

		
		
