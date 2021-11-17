/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.service.ServiceImpl;

import com.developer.demo.models.Employee;
import com.developer.demo.repository.EmployeeRepo;
import com.developer.demo.service.EmployeeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author nashey
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    EmployeeRepo userRepo;

    @Override
    public void saveUser(Employee user, String dob1, String immediateSupervisor) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsed = format.parse(dob1);
            user.setDob(parsed);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setActive(true);
            if (immediateSupervisor == null && !"".equals(immediateSupervisor)) {

                //myUser = usersDto.getById(Long.parseLong(id));
            } else {
                user.setImmediateSupervisor(userRepo.getById(Long.parseLong(immediateSupervisor)));
            }
            
            user.setRoles(user.getEmployeeCategory());
            userRepo.save(user);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isUserPresent(Employee user) {
        return false;
    }

    @Override
    public Employee getUser(String email) {
        return userRepo.findByEmployeeNumber(email).get();
    }

    @Override
    public Employee findById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<Employee> findBySupervisor(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
