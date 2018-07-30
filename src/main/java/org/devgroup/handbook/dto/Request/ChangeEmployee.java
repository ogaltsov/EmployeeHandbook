package org.devgroup.handbook.dto.Request;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeEmployee {
    @NonNull
    private long employeeId;
    private long positionId;
    private long grade;
    private BigDecimal salary;

    public boolean isCorrect() {
        if (positionId != 0 || grade != 0 || salary != null)
            return true;
        else
            return false;
    }

}
