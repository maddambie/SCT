package com.appdev.SCT.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.appdev.SCT.model.Course;
import com.appdev.SCT.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class WelcomePageController {

	@GetMapping("/academic")
	public String academic(HttpSession session, Model model) {
		return "academic";
}
}
