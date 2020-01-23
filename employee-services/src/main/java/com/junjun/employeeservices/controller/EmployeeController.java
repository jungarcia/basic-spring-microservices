package com.junjun.employeeservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junjun.employeeservices.entity.Employee;
import com.junjun.employeeservices.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	 
	@Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable String departmentId) {
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findEmployeeByOrganizationId(@PathVariable String organizationId) {
        return employeeService.findEmployeeByOrganizationId(organizationId);
    }
}