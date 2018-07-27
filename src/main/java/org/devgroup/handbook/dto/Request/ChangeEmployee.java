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
    private int positionId;
    private int gradeId;
    private BigDecimal salary;

    public boolean isCorrect() {
        if (positionId != 0 || gradeId != 0 || salary != null)
            return true;
        else
            return false;
    }

}
