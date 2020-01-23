package com.junjun.employeeservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junjun.employeeservices.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

	List<Employee> findByDepartmentId(String departmentId);
	List<Employee> findByOrganizationId(String organizationId);
}