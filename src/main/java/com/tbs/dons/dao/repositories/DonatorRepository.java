package com.tbs.dons.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbs.dons.dao.entities.Donator;

public interface DonatorRepository extends JpaRepository<Donator, Long> {

}
