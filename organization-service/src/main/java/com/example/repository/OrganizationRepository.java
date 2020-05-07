package com.example.repository;

import com.example.model.Organization;

import java.util.List;

public interface OrganizationRepository {
    Organization add(Organization organization);

    List<Organization> findAll();

    Organization findById(Long id);
}
