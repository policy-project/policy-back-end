package com.app.policy.repo;

import com.app.policy.dto.PolicyDto;
import com.app.policy.interfaces.PolicyInsured;
import com.app.policy.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

    @Query(value = "SELECT new com.app.policy.dto.PolicyDto(p.policyNumber, p.productNumber, p.insured.insuredId) " +
            "FROM Policy p JOIN Insured i on i.insuredId = p.insured.insuredId " +
            "WHERE i.insuredId = :id")
    List<PolicyDto> findPolicyByInsuredId(@Param("id") int id);

    List<Policy> findPolicyByProductNumber(@Param("id") int productNumber);

    @Query(value = "SELECT policy_id as policyNumber, product_id as productNumber," +
            " insured_id as insuredId, first_name as insuredFirstName, last_name as insuredLastName " +
            " FROM policies JOIN insureds on insureds.insured_id = policies.insured_insured_id", nativeQuery = true)
    List<PolicyInsured> findPolicyInsured();
}
