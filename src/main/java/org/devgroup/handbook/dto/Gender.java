package org.devgroup.handbook.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gender {
    @NonNull
    private int id;
    @NonNull
    private String name;
}