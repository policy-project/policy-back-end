package com.app.policy.services;

import com.app.policy.dto.InsuredDto;
import com.app.policy.dto.PolicyDto;
import com.app.policy.entities.Insured;
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
public class InsuredService {
    InsuredRepository insuredRepository;
    EntityManager entityManager;
    ModelMapper mapper;

    public List<InsuredDto> getAllInsured(){
        return insuredRepository.findAll().stream().map(insured -> mapper.map(insured, InsuredDto.class)).toList();
    }

    public InsuredDto getInsured(int id){
        Insured insured = insuredRepository.findById(id).orElse(null);
        if(insured == null){
            throw new EntityNotFoundException("Not found insured by id " + id);
        }
        return mapper.map(insured, InsuredDto.class);
    }

    public InsuredDto postInsured(InsuredDto request){
        Insured response = insuredRepository.save(mapper.map(request, Insured.class));
        return mapper.map(response, InsuredDto.class);
    }

    public List<InsuredDto> postInsured(List<InsuredDto> request){
        List<InsuredDto> res = new LinkedList<>();
        for (InsuredDto insuredDto:
                request) {
            Insured response = insuredRepository.save(mapper.map(insuredDto, Insured.class));
            res.add(mapper.map(response, InsuredDto.class));
        }
        return res;
    }
}
