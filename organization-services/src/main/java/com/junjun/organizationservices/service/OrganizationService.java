package com.junjun.organizationservices.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junjun.organizationservices.entity.Organization;
import com.junjun.organizationservices.repository.OrganizationRepository;

@Service
@Transactional
public class OrganizationService {

	@Autowired
    private OrganizationRepository organizationRepository;
	
	public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    public Organization addNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(String id, Organization organization) {
        organizationRepository.findById(id).ifPresent(o -> organization.setId(o.getId()));
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }
}