/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.service;

import com.developer.demo.models.EmployeeTimeSheet;
import com.developer.demo.models.MonthDaysTimeSheet;

/**
 *
 * @author nashey
 */
public interface TimeSheetService {
    public EmployeeTimeSheet getById(long id);
    public String saveEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet);
    
    public MonthDaysTimeSheet getMonthDaysTimeSheetById(long id);
    public String saveMonthDaysTimeSheet(MonthDaysTimeSheet mDaysTimeSheet);
    
    
    
}
