/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.developer.demo.dto;

import com.developer.demo.models.MonthTimeSheet;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nashey
 */

@Data

@NoArgsConstructor
@AllArgsConstructor

public class TimeSheetDto {
    private long month;
    private List<MonthTimeSheet> times;
    
}
