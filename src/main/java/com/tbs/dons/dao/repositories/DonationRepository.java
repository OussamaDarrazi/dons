package com.tbs.dons.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbs.dons.dao.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    public List<Donation> findByActCharId(Long actCharId);
}
