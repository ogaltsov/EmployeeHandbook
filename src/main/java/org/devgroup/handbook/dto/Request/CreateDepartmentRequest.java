package org.devgroup.handbook.dto.Request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDepartmentRequest {

    @NonNull
    private String name;

    private long parentDepartment;

    @NonNull
    private long headEmployee;
}
