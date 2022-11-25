package com.app.policy.controller;

import com.app.policy.common.Constants;
import com.app.policy.common.StatusDescription;
import com.app.policy.dto.PolicyDto;
import com.app.policy.services.PolicyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.POLICY_API.MAIN)
@Validated
@CrossOrigin
@Log4j2
@AllArgsConstructor
public class PolicyController {

    PolicyService policyService;

    @GetMapping
    ResponseEntity getAllPolicy(){

        ResponseEntity response = new ResponseEntity(null, HttpStatus.OK);

        String statusDescription = StatusDescription.SUCCESSFUL.toString();
        response.getHeaders().add(Constants.STATUS_DESCRIPTION, statusDescription);

        return response;
    }

    @GetMapping("/{id}")
    ResponseEntity getPolicy(@PathVariable @Min(value = Constants.POLICY_MIN_ID) @Max(value = Constants.POLICY_MAX_ID) int id){

        ResponseEntity response = new ResponseEntity(null, HttpStatus.OK);

        String statusDescription = StatusDescription.SUCCESSFUL.toString();
        response.getHeaders().add(Constants.STATUS_DESCRIPTION, statusDescription);

        return response;
    }

    @GetMapping(Constants.POLICY_API.POLICY_BY_INSURED + "/{id}")
    ResponseEntity getPolicyByInsured(@PathVariable @Min(value = Constants.INSURED_MIN_ID) @Max(value = Constants.INSURED_MAX_ID) int id){

        ResponseEntity response = new ResponseEntity(null, HttpStatus.OK);

        String statusDescription = StatusDescription.SUCCESSFUL.toString();
        response.getHeaders().add(Constants.STATUS_DESCRIPTION, statusDescription);

        return response;
    }

    @PostMapping
    ResponseEntity postPolicy(@Valid @RequestBody PolicyDto request){

        ResponseEntity response = new ResponseEntity(null, HttpStatus.OK);

        String statusDescription = StatusDescription.SUCCESSFUL.toString();
        response.getHeaders().add(Constants.STATUS_DESCRIPTION, statusDescription);

        return response;
    }
}
