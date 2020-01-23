package com.junjun.organizationservices.controller;

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

import com.junjun.organizationservices.entity.Organization;
import com.junjun.organizationservices.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<Organization> findAllOrganization() {
        return organizationService.findAllOrganization();
    }

    @GetMapping("/{id}")
    public Organization findOrganizationById(@PathVariable String id) {
    	// TODO this comment below
        //return organizationService.findOrganizationById(id);
    	return new Organization();
    }

    @PostMapping
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.addNewOrganization(organization);
    }

    @PutMapping("/{id}")
    public Organization putOrganization(@PathVariable String id, @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
    }
}