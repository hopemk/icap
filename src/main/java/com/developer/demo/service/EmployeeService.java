/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.service;

import com.developer.demo.models.Employee;
import java.util.List;

/**
 *
 * @author nashey
 */
public interface EmployeeService {
    
    public void saveUser(Employee user, String dob1, String immediateSupervisor);
	
	public boolean isUserPresent(Employee user);
	
	public Employee getUser(String email);
        public Employee findById(Long id);
        
        public List<Employee> findBySupervisor(Long id);
    
}
