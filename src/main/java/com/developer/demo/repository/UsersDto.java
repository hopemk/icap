/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.repository;

import com.developer.demo.models.Employee;
import com.developer.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nashey
 */
@Repository
public interface UsersDto extends JpaRepository<Employee, Long>{
    
}
