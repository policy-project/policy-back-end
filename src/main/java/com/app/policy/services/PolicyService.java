package com.app.policy.services;

import com.app.policy.dto.PolicyDto;
import com.app.policy.entities.Insured;
import com.app.policy.entities.Policy;
import com.app.policy.interfaces.PolicyInsured;
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
import java.util.Optional;

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
        List<PolicyDto> response = policyRepository.findPolicyByInsuredId(id);
        return response;
    }


    public PolicyDto postPolicy(PolicyDto request) {
        Insured insured = insuredRepository.getReferenceById(request.getInsuredId());
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
            Insured insured = insuredRepository.getReferenceById(policyDto.getInsuredId());
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

    public List<PolicyInsured> getAllPolicyInsuredQuery() {
        return policyRepository.findPolicyInsured();
    }

    public List<PolicyDto> getPolicyByProductNumber(int id){
        return policyRepository.findPolicyByProductNumber(id).stream()
                .map(policy -> new PolicyDto(policy.getPolicyNumber(), policy.getProductNumber(), policy.getInsured().getInsuredId()))
                .toList();
    }

    public PolicyDto removePolicy(int id){
        Policy policy = policyRepository.findById(id).orElse(null);
        if (policy == null){
            throw new EntityNotFoundException("not found policy by id " + id);
        }
        PolicyDto response = mapper.map(policy, PolicyDto.class);
        response.setInsuredId(policy.getInsured().getInsuredId());
        policyRepository.deleteById(id);
        return response;
    }

}
