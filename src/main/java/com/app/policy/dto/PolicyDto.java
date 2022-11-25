package com.app.policy.dto;


import com.app.policy.common.Constants;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class PolicyDto {
    @Min(value = Constants.POLICY_MIN_ID) @Max(value = Constants.POLICY_MAX_ID)
    int policyNumber;
    @Min(value = Constants.PRODUCT_MIN_ID) @Max(value = Constants.PRODUCT_MAX_ID)
    int productNumber;
    @NotNull
    int insured;
}
