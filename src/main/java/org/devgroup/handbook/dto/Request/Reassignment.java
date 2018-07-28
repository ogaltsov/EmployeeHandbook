package org.devgroup.handbook.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reassignment {

    private long idDepToReassign;

    private long idNewParentDep;
}
