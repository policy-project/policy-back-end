package com.app.policy.repo;

import com.app.policy.dto.PolicyDto;
import com.app.policy.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    @Query(value = "select policy_id as policyNumber from policies join insureds on policies_insured_id = insured_id where insured_id = :id", nativeQuery = true)
//    @Query(value = "select ALL from policies join insureds on policies.insured_id = insureds.insured_id", nativeQuery = true)
    List<Policy> findPolicyByInsuredId(@Param("id") int insuredId);
}
