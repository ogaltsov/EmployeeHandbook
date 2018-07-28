package org.devgroup.handbook.dto.Request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferEmployee {
    @NonNull
    private long employeeId;
    @NonNull
    private long depIdFrom; //todo: is redundant?
    @NonNull
    private long depIdTo;

}
