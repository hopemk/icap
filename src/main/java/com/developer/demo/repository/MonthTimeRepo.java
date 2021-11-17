/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.repository;

import com.developer.demo.models.MonthTimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nashey
 */
public interface MonthTimeRepo extends JpaRepository<MonthTimeSheet, Long>{
    
}
