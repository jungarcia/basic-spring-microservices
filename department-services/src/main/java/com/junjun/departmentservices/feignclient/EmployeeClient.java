package com.junjun.departmentservices.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.junjun.departmentservices.entity.Employee;

@FeignClient("employee-service")
public interface EmployeeClient {

	@GetMapping("/employees/department/{departmentId}")
    List<Employee> findEmployeeByDepartmentId(@PathVariable String departmentId);
}