package com.appdev.SCT.controller;

import java.util.List;
import java.util.Map;

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
import com.appdev.SCT.model.Program;
import com.appdev.SCT.model.StudentEnrollmentHdr;
import com.appdev.SCT.model.Subject;
import com.appdev.SCT.model.User;
import com.appdev.SCT.repository.CourseRepository;
import com.appdev.SCT.repository.TeacherRepository;
import com.appdev.SCT.repository.UserRepository;
import com.appdev.SCT.repository.ProgramRepository;
import com.appdev.SCT.service.CourseService;
import com.appdev.SCT.service.ProgramService;
import com.appdev.SCT.service.SubjectService;
import com.appdev.SCT.service.UserService;
import com.appdev.SCT.service.SpProgressService;
import com.appdev.SCT.service.SpCurriculumService;
import com.appdev.SCT.repository.StudentEnrollmentHdrRepository;
import com.appdev.SCT.service.StudentcoursesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
			
			@Autowired
			private UserRepository UserRepository;
			@Autowired
			private CourseRepository CourseRepository;
			@Autowired
			private TeacherRepository teacherRepository;
			@Autowired
			private ProgramRepository ProgramRepository;
			
			@Autowired
		    private UserService userService;
			@Autowired
		    private CourseService CourseService;
			
			@Autowired
		    private SpProgressService SpProgressService;
			

		    
			@Autowired
		    private SubjectService SubjectService;
			
			@Autowired
		    private ProgramService ProgramService;
			
			
			@Autowired
			private StudentEnrollmentHdrRepository StudentcoursesRepository;
			@Autowired
		    private StudentcoursesService StudentcoursesService;
			
			
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
		    
		    @GetMapping("/admin/dash")
		    public String adminDashboard(Model model) {
		        model.addAttribute("adminName", "Admin"); // Later replace with session data
		        return "admin";
		    }
		    

			@GetMapping("/curriculum")
			public String curriculum(HttpSession session, Model model) {
				String studentId = (String) session.getAttribute("studentid"); // Get user ID from session
				if (studentId != null) {
				    User user = userService.findBystudentid(studentId); // Fetch user from database
				   
				    
				    model.addAttribute("user", user);
				    
				    int userLogged = 1;
					model.addAttribute("userLogged", userLogged);
				    //return "curriculum";
				} else {
					
					
				    
					
					int userLogged = 0;
					
					model.addAttribute("userLogged", userLogged);
					 
				    //return "redirect:/login";
				}
				List<Course> courses = CourseRepository.findAll();
				model.addAttribute("courses", courses);
				return "curriculum";
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
		        model.addAttribute("courses", CourseRepository.findAll());
		        
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
		        	
		        	Teacher teacher = new Teacher(teacherId, fullN, email, phone, department, facultyId, password, eduBack, experience);
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
		    
		    @PostMapping("/api/courses")
		    public String getCourses(@RequestParam int id, Model model ) {
		    	Course course = CourseService.findById(id);
		    	String courseid = course.getProgram();
		    	
		    	List<Subject> subject = SubjectService.findByCourseid(courseid);
		    	List<Program> program = ProgramService.findByCourseid(courseid);
		        model.addAttribute("course", course);
		        model.addAttribute("subject", subject);
		        model.addAttribute("program", program);
		        
		        
		        
		        
				return "/loadDesc";
		    	
		    }
		    
		    
		    @Autowired
		    private SpCurriculumService SpCurriculumService;
		    @PostMapping("/enroll")
		    public String enrollForm(@RequestParam String studentid, @RequestParam String courseid,@RequestParam int year_level,Model model) {
		    	{
		    		model.addAttribute("message", "Success");
		    	}	
		        model.addAttribute("studentid", studentid);
		        model.addAttribute("courseid", courseid);
		        model.addAttribute("year_level", year_level);
		       
	            SpCurriculumService.runSPCurriculum(studentid, courseid,year_level,0);

	            return "success";

		        
		    }
		    
		    @GetMapping("/progress")
		    public String progress(HttpSession session, Model model) {

		        String studentId = (String) session.getAttribute("studentid");

		        if (studentId != null) {

		            User user = userService.findBystudentid(studentId);
		            model.addAttribute("user", user);

		            List<Map<String, Object>> studentcourses =
		                    SpProgressService.runSPProgress("", 1, studentId, 1, 3);

		            model.addAttribute("studentcourses", studentcourses);

		            // ✅ Check if data exists first
		            if (studentcourses != null && !studentcourses.isEmpty()) {

		                Map<String, Object> row = studentcourses.get(0);

		                String program = (String) row.get("courseid");
		                int yearLevel = ((Number) row.get("year_level")).intValue();
		                int status = ((Number) row.get("status")).intValue();
		                int id = ((Number) row.get("id")).intValue();

		                if (status == 3) {

		                    List<Map<String, Object>> subject =
		                            SpProgressService.runSPProgress(program, yearLevel, studentId, id, 2);

		                    model.addAttribute("subject", subject);
		                }

		                List<Map<String, Object>> course =
		                        SpProgressService.runSPProgress(program, yearLevel, studentId, id, 1);

		                model.addAttribute("course", course);
		            }

		            return "progress";

		        } else {
		            return "redirect:/login";
		        }
		    }



			
		    
		    
	}

		
		
