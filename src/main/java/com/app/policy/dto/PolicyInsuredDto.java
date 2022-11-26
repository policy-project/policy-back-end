package com.app.policy.dto;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class PolicyInsuredDto {
    int policyNumber;
    int productNumber;
    int insuredId;
    String insuredFirstName;
    String insuredLastName;
}
