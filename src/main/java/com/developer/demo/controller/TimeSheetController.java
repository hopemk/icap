/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.controller;

import com.developer.demo.dto.TimeSheetDto;
import com.developer.demo.models.Employee;
import com.developer.demo.service.TimeSheetService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nashey
 */
@RestController
public class TimeSheetController {
    
    @Autowired
    private TimeSheetService timeSheet;
    
    
    @RequestMapping(value = "/posttimesheet", method = RequestMethod.POST)
	public String registerUser( @RequestBody TimeSheetDto timeSheet) {
            
                
		return "saved";
	}
}
