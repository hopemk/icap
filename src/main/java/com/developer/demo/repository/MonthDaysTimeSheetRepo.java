/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.repository;

import com.developer.demo.models.MonthDaysTimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nashey
 */
@Repository
public interface MonthDaysTimeSheetRepo extends JpaRepository<MonthDaysTimeSheet, Long>{
    
}
