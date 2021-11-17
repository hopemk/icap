/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.service.ServiceImpl;

import com.developer.demo.models.EmployeeTimeSheet;
import com.developer.demo.models.MonthDaysTimeSheet;
import com.developer.demo.repository.EmployeeRepo;
import com.developer.demo.repository.EmployeeTimeSheetRepo;
import com.developer.demo.repository.MonthDaysTimeSheetRepo;
import com.developer.demo.repository.MonthTimeRepo;
import com.developer.demo.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nashey
 */
@Service
public class TimeSheetServiceImpl implements TimeSheetService{
    
    @Autowired
    EmployeeRepo userRepo;
    
    @Autowired
    EmployeeTimeSheetRepo employeeTimeSheetRepo;
    
    @Autowired
    MonthDaysTimeSheetRepo monthDaysTimeSheetRepo;
    
    @Autowired
    MonthTimeRepo monthTimeRepo;

    @Override
    public EmployeeTimeSheet getById(long id) {
        return employeeTimeSheetRepo.findById(id).get();
    }

    @Override
    public String saveEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet) {
        employeeTimeSheetRepo.save(employeeTimeSheet);
        return "saved";
    }

    @Override
    public MonthDaysTimeSheet getMonthDaysTimeSheetById(long id) {
        return monthDaysTimeSheetRepo.getById(id);
    }

    @Override
    public String saveMonthDaysTimeSheet(MonthDaysTimeSheet mDaysTimeSheet) {
        monthDaysTimeSheetRepo.save(mDaysTimeSheet);
        return "saved";
    }
    
}
