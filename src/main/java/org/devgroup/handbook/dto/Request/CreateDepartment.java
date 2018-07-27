package org.devgroup.handbook.dto.Request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDepartment {

    @NonNull
    private String name;

    private long parentDepartment;

    @NonNull
    private long headEmployee;
}
