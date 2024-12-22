package com.jbk.Hibernate_HQL_SB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Hibernate_HQL_SB.dao.EmployeeDao;
import com.jbk.Hibernate_HQL_SB.entity.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public String insertData(Employee employee) 
    {
        return employeeDao.insertData(employee); 
    }

    public String updateData(Employee employee, int eid) 
    {
        return employeeDao.updateData(employee, eid); 
    }

    public String deleteData(int eid) 
    {
        return employeeDao.deleteData(eid); 
    }

    public List<Employee> displayAllData() 
    {
        return employeeDao.displayallData(); 
    }

    public Employee fetchSingleData(int eid) 
    {
        return employeeDao.fetchsingleData(eid); 
    }
}
