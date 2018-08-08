package org.devgroup.handbook.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @NonNull
    private long id;
    @NonNull
    private String name;
    private Department parentDep;
    private Employee head;
}
