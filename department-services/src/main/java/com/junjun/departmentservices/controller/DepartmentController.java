package com.junjun.departmentservices.controller;

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

import com.junjun.departmentservices.entity.Department;
import com.junjun.departmentservices.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable String id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping
    public Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

    @PutMapping("/{id}")
    public Department putDepartment(@PathVariable String id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findDepartmentByOrganizationId(@PathVariable String organizationId) {
        return departmentService.findDepartmentByOrganizationId(organizationId);
    }
}