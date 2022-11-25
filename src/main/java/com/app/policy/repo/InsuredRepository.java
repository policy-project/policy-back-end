package com.app.policy.repo;

import com.app.policy.entities.Insured;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuredRepository extends JpaRepository<Insured, Integer> {
}
