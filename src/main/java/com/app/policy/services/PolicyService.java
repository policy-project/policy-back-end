package com.app.policy.services;

import com.app.policy.dto.PolicyDto;
import com.app.policy.repo.PolicyRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class PolicyService {
    PolicyRepository policyRepository;
    EntityManager entityManager;
    ModelMapper mapper;

    List<PolicyDto> getAllPolicy(){
        //TODO
        return null;
    }

    PolicyDto getPolicy(int id){
        //TODO
        return null;
    }

    List<PolicyDto> getPolicyByInsured(){
        //TODO
        return null;
    }

    PolicyDto postPolicy(PolicyDto policy){
        //TODO
        return null;
    }
}
