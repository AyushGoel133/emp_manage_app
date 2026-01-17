package org.ayush.em_project;

import java.util.List;

public interface Employeeservice {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    Employee readEmployee(Long id);
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id , Employee employee);
     
} 
