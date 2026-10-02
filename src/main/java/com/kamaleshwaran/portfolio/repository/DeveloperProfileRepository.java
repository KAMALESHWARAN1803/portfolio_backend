package com.kamaleshwaran.portfolio.repository;

import com.kamaleshwaran.portfolio.model.DeveloperProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperProfileRepository extends JpaRepository<DeveloperProfile, Long> {
}
