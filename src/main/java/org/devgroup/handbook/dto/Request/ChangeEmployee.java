package org.devgroup.handbook.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeEmployee {

    @NotNull(message = "Field \"Employee ID\" must not be empty")
    @Positive(message = "\"Employee ID\" must be positive")
    private Long employeeId;


    @Positive(message = "\"Position ID\" must be positive")
    private Long positionId;


    @Positive(message = "\"Grade\" must be positive")
    private Long grade;


    @Positive(message = "\"Salary\" must be positive")
    private BigDecimal salary;

    public boolean isCorrect() {
        if (positionId != null || grade != null || salary != null)
            return true;
        else
            return false;
    }

}
