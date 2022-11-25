package com.app.policy.dto;


import com.app.policy.common.Constants;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class PolicyDto {
    @Min(value = Constants.MIN_ID) @Max(value = Constants.MAX_ID)
    int policyNumber;
    @NotNull
    int productNumber;
    @NotNull
    InsuredDto insured;
}
