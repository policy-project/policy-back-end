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
public class InsuredDto {
    @Min(value = Constants.INSURED_MIN_ID) @Max(value = Constants.INSURED_MAX_ID)
    int insuredId;
    @NotEmpty
    String insuredFirstName;
    @NotEmpty
    String insuredLastName;
}
