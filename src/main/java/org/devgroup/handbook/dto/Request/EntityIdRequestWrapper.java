package org.devgroup.handbook.dto.Request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class EntityIdRequestWrapper {

    @NotNull(message = "Field \"Id\" must not be empty")
    @Positive(message = "\"Id\" must be positive")
    private Long id;
}
