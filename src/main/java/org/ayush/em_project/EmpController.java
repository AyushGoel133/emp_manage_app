package org.ayush.em_project;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("http://localhost:3000/")
public class EmpController {

    // Employeeservice employeeservice = new EmployeeserviceImpl();

    @Autowired
    Employeeservice employeeservice;

    @GetMapping("employees")
    public List<Employee> getAllEmploye() {
        return employeeservice.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeservice.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmploye(@RequestBody Employee employee) {
        return employeeservice.createEmployee(employee);

    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeservice.deleteEmployee(id)) {
            return "Delete Succesfully";
        }
        return "Not found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeservice.updateEmployee(id, employee);
    }

}
