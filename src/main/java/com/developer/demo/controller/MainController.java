/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author nashey
 */
@RestController
public class MainController {
    
    
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    
    @GetMapping("/hrmanager")
    public ModelAndView hr(){
        ModelAndView mv = new ModelAndView("hrmanager");
        return mv;
    }
    @GetMapping("/supervisor")
    public ModelAndView supervisor(){
        ModelAndView mv = new ModelAndView("supervisor");
        return mv;
    }
    
    @GetMapping("/employee")
    public ModelAndView employee(){
        ModelAndView mv = new ModelAndView("employee");
        return mv;
    }
    @GetMapping("/timesheet")
    public ModelAndView timeSheet(){
        ModelAndView mv = new ModelAndView("timesheet");
        return mv;
    }
    
}
