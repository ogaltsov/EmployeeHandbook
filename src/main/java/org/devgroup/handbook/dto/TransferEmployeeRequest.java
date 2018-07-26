package org.devgroup.handbook.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferEmployeeRequest {
    @NonNull
    private long employeeId;
    @NonNull
    private long depIdFrom;
    @NonNull
    private long depIdTo;

}
