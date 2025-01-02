package com.tbs.dons.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbs.dons.dao.entities.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

}
