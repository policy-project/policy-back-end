package com.app.policy.services;

import com.app.policy.dto.InsuredDto;
import com.app.policy.dto.PolicyDto;
import com.app.policy.repo.InsuredRepository;
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
public class InsuredService {
    InsuredRepository insuredRepository;
    EntityManager entityManager;
    ModelMapper mapper;

    List<InsuredDto> getAllInsured(){
        //TODO
        return null;
    }

    InsuredDto getInsured(int id){
        //TODO
        return null;
    }

    InsuredDto postInsured(PolicyDto policy){
        //TODO
        return null;
    }
}
