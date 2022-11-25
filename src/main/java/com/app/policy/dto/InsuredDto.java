package com.app.policy.dto;

import com.app.policy.common.Constants;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class InsuredDto {
    @Min(value = Constants.MIN_ID) @Max(value = Constants.MAX_ID)
    int insuredId;
    @NotEmpty
    String insuredFirstName;
    @NotEmpty
    String insuredLastName;
}
