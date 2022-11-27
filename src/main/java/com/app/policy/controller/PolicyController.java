package com.app.policy.controller;

import com.app.policy.common.Constants;
import com.app.policy.common.StatusDescription;
import com.app.policy.dto.PolicyDto;
import com.app.policy.interfaces.PolicyInsured;
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

import java.util.List;

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
        log.debug("get all policy end point");
        List<PolicyDto> response = policyService.getAllPolicy();
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @GetMapping(Constants.POLICY_API.POLICY_INSURED)
    ResponseEntity getAllPolicyInsured(){
        log.debug("get all policy insured end point");
        List<PolicyInsured> response = policyService.getAllPolicyInsuredQuery();
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @GetMapping("/{id}")
    ResponseEntity getPolicy(@PathVariable @Min(value = Constants.POLICY_MIN_ID) @Max(value = Constants.POLICY_MAX_ID) int id){
        log.debug("get policy end point by id {}", id);
        PolicyDto response = policyService.getPolicy(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @GetMapping(Constants.POLICY_API.POLICY_BY_INSURED + "/{id}")
    ResponseEntity getPolicyByInsured(@PathVariable @Min(value = Constants.INSURED_MIN_ID) @Max(value = Constants.INSURED_MAX_ID) int id){
        log.debug("get policy by insured id {}", id);
        List<PolicyDto> response = policyService.getPolicyByInsured(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @GetMapping(Constants.POLICY_API.POLICY_BY_PRODUCT + "/{id}")
    ResponseEntity getPolicyByProductNumber(@PathVariable @Min(value = Constants.PRODUCT_MIN_ID) @Max(value = Constants.PRODUCT_MAX_ID) int id){
        log.debug("get policy by product id {}", id);
        List<PolicyDto> response = policyService.getPolicyByProductNumber(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @PostMapping
    ResponseEntity postPolicy(@Valid @RequestBody PolicyDto request){
        log.debug("post policy end point {}", request);
        PolicyDto response = policyService.postPolicy(request);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @PostMapping(Constants.POLICY_API.ADD_ALL)
    ResponseEntity postPolicies(@Valid @RequestBody List<PolicyDto> request){
        log.debug("post policy list end point {}", request);
        List<PolicyDto> response = policyService.postPolicy(request);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

}
