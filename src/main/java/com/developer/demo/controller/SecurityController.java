package com.developer.demo.controller;

import com.developer.demo.models.Employee;
import com.developer.demo.repository.UsersDto;
import com.developer.demo.service.EmployeeService;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class SecurityController {
	
	@Autowired
	EmployeeService userService;
        
        @Autowired
        private UsersDto usersDto;
	
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("register");
		//Employee user = new Employee();
                List<Employee> employees = usersDto.findAll();
		mv.addObject("employees", employees);
		mv.setViewName("register");
		return mv;
	}
	
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid Employee user, @RequestParam String dob1, @RequestParam(required=false) String id, BindingResult bindResult, ModelMap modelmap) {
            
                System.out.println("registering new user");
                System.out.println("Date of birth is : " +user.getDob());
		ModelAndView mv = new ModelAndView();
		if(bindResult.hasErrors()) {
			mv.addObject("successMessage", "please correct the errors in form");
			System.out.println("bindingResult :" + bindResult);
		}
		else if(userService.isUserPresent(user)){
			mv.addObject("successMesaage", "user is already present");
		}
		else {
			userService.saveUser(user, dob1, id);
			mv.addObject("successMesaage", "user created successfully");
			System.out.println(user + "created successfully");
		}
		mv.addObject("user", user);
		mv.setViewName("login");
		return mv;
	}

}
