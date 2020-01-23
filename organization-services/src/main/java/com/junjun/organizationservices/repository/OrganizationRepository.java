package com.junjun.organizationservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junjun.organizationservices.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
