/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.controller;

import com.developer.demo.models.Employee;
import com.developer.demo.repository.UsersDto;
import com.developer.demo.models.Users;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nashey
 */
@RestController
public class UsersController {
    
    @Autowired
    private UsersDto usersDto;
    
            /*
    @PostMapping("save")
    public String save(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String dob, @RequestParam String jobTitle) throws ParseException{
        Users myUser;
        if(id == null && !"".equals(id)){
           
            myUser = usersDto.getById(Long.parseLong(id));
        }
        else{
             myUser = new Users();
        }
            myUser.setFirstName(firstName);
            myUser.setLastName(lastName);
            myUser.setJobTitle(jobTitle);
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(dob);
            myUser.setDob(parsed);
            usersDto.save(myUser);
        return "done";
    }
    */
   @GetMapping("/allusers")
   public List<Employee> getUsers(){
       return usersDto.findAll();
       
   }
    
}
