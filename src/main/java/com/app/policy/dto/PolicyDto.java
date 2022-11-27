package com.app.policy.dto;


import com.app.policy.common.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDto {
    @Min(value = Constants.POLICY_MIN_ID) @Max(value = Constants.POLICY_MAX_ID)
    int policyNumber;
    @Min(value = Constants.PRODUCT_MIN_ID) @Max(value = Constants.PRODUCT_MAX_ID)
    int productNumber;
    @Min(value = Constants.INSURED_MIN_ID) @Max(value = Constants.INSURED_MAX_ID)
    int insuredId;
}
