package com.aimdek.spring.MVC.dao;

import java.util.List;

import com.aimdek.spring.MVC.model.Employee;
 

public interface EmployeeDAO {
     
    public void saveOrUpdate(Employee employee);
     
    public void delete(int employeeId);
     
    public Employee get(int employeeId);
     
    public List<Employee> list();
}