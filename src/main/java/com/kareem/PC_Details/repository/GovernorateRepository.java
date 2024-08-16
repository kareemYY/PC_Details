package com.kareem.PC_Details.repository;

import com.kareem.PC_Details.entity.Governorate;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GovernorateRepository extends JpaRepository<Governorate, Integer> {
}
