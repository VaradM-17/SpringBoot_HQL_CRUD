package com.jbk.Hibernate_HQL_SB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Hibernate_HQL_SB.entity.Employee;
import com.jbk.Hibernate_HQL_SB.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeservice;

    @PostMapping("/insertdata")
    public String insertData(@RequestBody Employee e) {
        String msg = employeeservice.insertData(e);
        return msg;
    }

    @PutMapping("/updatedata/{eid}")
    public String updateData(@RequestBody Employee e, @PathVariable int eid) {
        String msg = employeeservice.updateData(e, eid);
        return msg;
    }

    @DeleteMapping("/deletedata/{eid}")
    public String deletedata(@PathVariable int eid) {
        String msg = employeeservice.deleteData(eid);
        return msg;
    }

   
}
