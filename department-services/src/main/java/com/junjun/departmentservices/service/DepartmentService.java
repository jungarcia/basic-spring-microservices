package com.junjun.departmentservices.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junjun.departmentservices.entity.Department;
import com.junjun.departmentservices.entity.Employee;
import com.junjun.departmentservices.feignclient.EmployeeClient;
import com.junjun.departmentservices.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

	@Autowired
    private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }
	
	public Department findDepartmentByIdRecovery(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        departmentRepository.findById(departmentId).ifPresent(d -> department.setId(d.getId()));
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public List<Department> findDepartmentByOrganizationId(String organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

	public Department findDepartmentById(String id) {
		//return departmentRepository.findById(id).orElse(null);
		
		Optional<Department> department = departmentRepository.findById(id);

        department.ifPresent(d -> {
            List<Employee> employees = employeeClient.findEmployeeByDepartmentId(d.getId());
            d.setEmployees(employees);
        });

        return department.orElse(null);
	}
}