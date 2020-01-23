package com.junjun.departmentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junjun.departmentservices.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

	List<Department> findByOrganizationId(String organizationId);
}