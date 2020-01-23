package com.junjun.organizationservices.entity;
// Generated Dec 24, 2019 4:27:48 PM by Hibernate Tools 5.1.7.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Organization generated by hbm2java
 */
@Entity
@Table(name = "organization", catalog = "jundb")
public class Organization implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3086699273072713472L;
	
	private String id;
	private String name;
	private String address;
	private List<Department> departments = new ArrayList<Department>();
	private List<Employee> employees = new ArrayList<Employee>();

	public Organization() {
	}

	public Organization(String id) {
		this.id = id;
	}

	public Organization(String id, String name, String address, List<Department> departments, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.departments = departments;
		this.employees = employees;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 10)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
	public List<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}