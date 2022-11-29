package com.app.policy.controller;

import com.app.policy.common.Constants;
import com.app.policy.common.StatusDescription;
import com.app.policy.dto.InsuredDto;
import com.app.policy.dto.PolicyDto;
import com.app.policy.services.InsuredService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.INSURED_API.MAIN)
@Validated
@CrossOrigin
@Log4j2
@AllArgsConstructor
public class InsuredController {

    InsuredService insuredService;

    @GetMapping
    ResponseEntity getAllInsured(){
        log.debug("get all insured end point");
        List<InsuredDto> response = insuredService.getAllInsured();
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @GetMapping("/{id}")
    ResponseEntity getInsured(@PathVariable @Min(value = Constants.INSURED_MIN_ID) @Max(value = Constants.INSURED_MAX_ID) int id){
        log.debug("get insured end point by id {}", id);
        InsuredDto response = insuredService.getInsured(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @PostMapping
    ResponseEntity postInsured(@Valid @RequestBody InsuredDto request){
        log.debug("post insured end point {}", request);
        InsuredDto response = insuredService.postInsured(request);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

    @PostMapping(Constants.INSURED_API.ADD_ALL)
    ResponseEntity postInsured(@Valid @RequestBody List<InsuredDto> request){
        log.debug("post insured list end point {}", request);
        List<InsuredDto> response = insuredService.postInsured(request);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }
    @DeleteMapping("/{id}")
    ResponseEntity removeInsured(@PathVariable int id){
        InsuredDto response = insuredService.removeInsured(id);
        return ResponseEntity.status(HttpStatus.OK)
                .header(Constants.STATUS_DESCRIPTION, StatusDescription.SUCCESSFUL.toString())
                .body(response);
    }

}
