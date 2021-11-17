/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nashey
 */

@Entity
@Data
@Table(name = "month_time_sheet")
@NoArgsConstructor
@AllArgsConstructor

public class MonthTimeSheet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_time_sheet")
    private EmployeeTimeSheet employee;
    
    private int month;
    
}
