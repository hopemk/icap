/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the edi;tor.
 */
package com.developer.demo.models;

import com.sun.istack.NotNull;
import java.util.Date;
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
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author nashey
 */
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String jobTitle;
    private String employeeNumber;
    private String employeeCategory;

    @ManyToOne
    @JoinColumn(name = "supervisor")
    private Employee immediateSupervisor;

    @NotNull
    @Length(min = 5)
    private String password;

    private boolean active;

    private String roles;
}
