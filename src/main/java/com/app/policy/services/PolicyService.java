package com.app.policy.services;

import com.app.policy.dto.PolicyDto;
import com.app.policy.dto.PolicyInsuredDto;
import com.app.policy.entities.Insured;
import com.app.policy.entities.Policy;
import com.app.policy.repo.InsuredRepository;
import com.app.policy.repo.PolicyRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class PolicyService {

    PolicyRepository policyRepository;
    EntityManager entityManager;
    InsuredRepository insuredRepository;
    ModelMapper mapper;

    public List<PolicyDto> getAllPolicy() {
        return policyRepository.findAll().stream().map(policy -> policy.getPolicyDto()).toList();
    }

    public PolicyDto getPolicy(int id) {
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy == null) {
            throw new EntityNotFoundException("Not found policy id " + id);
        }
        return policy.getPolicyDto();

    }

    public List<PolicyDto> getPolicyByInsured(int id) {
        List<PolicyDto> response = policyRepository.findPolicyByInsuredId(id).stream().map(policy -> policy.getPolicyDto()).toList();
        if (response.size() == 0) {
            throw new EntityNotFoundException("Not found policy by id insured " + id);
        }
        return response;
    }


    public PolicyDto postPolicy(PolicyDto request) {
        Insured insured = insuredRepository.findById(request.getInsuredId()).orElse(null);
        if (insured == null) {
            throw new EntityNotFoundException("Not found insured by id " + request.getInsuredId());
        }
        Policy policy = mapper.map(request, Policy.class);
        policy.setInsured(insured);
        Policy response = policyRepository.save(policy);
        return mapper.map(response, PolicyDto.class);
    }

    public List<PolicyDto> postPolicy(List<PolicyDto> request) {
        List<PolicyDto> res = new LinkedList<>();
        for (PolicyDto policyDto : request) {
            Insured insured = insuredRepository.findById(policyDto.getInsuredId()).orElse(null);
            if (insured == null) {
                break;
            }
            Policy policy = mapper.map(policyDto, Policy.class);
            policy.setInsured(insured);
            Policy response = policyRepository.save(policy);
            res.add(mapper.map(response, PolicyDto.class));
        }
        return res;
    }

    public List<PolicyInsuredDto> getAllPolicyInsured() {
        List<PolicyInsuredDto> res = new LinkedList<>();
        List<Policy> policies = policyRepository.findAll();
        for (Policy policy :
                policies) {
            log.debug("{}", policy);
            Insured insured = policy.getInsured();
            res.add(PolicyInsuredDto.builder().policyNumber(policy.getPolicyNumber())
                    .productNumber(policy.getProductNumber())
                    .insuredId(insured.getInsuredId())
                    .insuredFirstName(insured.getInsuredFirstName())
                    .insuredLastName(insured.getInsuredLastName())
                    .build());
        }
        return res;
    }
}
