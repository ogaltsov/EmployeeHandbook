package org.devgroup.handbook.dto.Request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferEmployee {
    @NotNull(message = "Field \"Employee ID\" must not be empty")
    @Positive(message = "\"Employee ID\" must be positive")
    private long employeeId;


    @NotNull(message = "Field \"Department ID\" must not be empty")
    @Positive(message = "\"Department ID\" must be positive")
    private long depIdTo;

}
