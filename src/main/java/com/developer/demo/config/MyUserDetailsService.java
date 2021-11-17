package com.developer.demo.config;

import com.developer.demo.models.Employee;
import com.developer.demo.repository.EmployeeRepo;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	EmployeeRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String employeeNumber) throws UsernameNotFoundException{
		Optional<Employee> user; 
            user = userRepository.findByEmployeeNumber(employeeNumber);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found" + employeeNumber));
		return user.map(MyUserDetails::new).get();
	}
}
