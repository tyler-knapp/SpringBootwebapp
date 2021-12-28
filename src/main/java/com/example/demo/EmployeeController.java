package com.example.demo;

import com.example.demo.model.Employee;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
public class EmployeeController {
    
    private EmployeeDAO employeeDAO;
    
    @RequestMapping(path = "employees", method = RequestMethod.GET)
    public List<Employee> list(){
        return employeeDAO.getAllEmployees();
    }
}
