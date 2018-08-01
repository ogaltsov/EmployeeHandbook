package org.devgroup.handbook.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devgroup.handbook.dto.Certificate;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployee {

    @NotEmpty(message = "Field \"Name\" must not be empty")
    @Size(min = 2, max = 50, message = "\"Name\" length must be from 2 to 20")
    @Pattern(regexp = "[a-zA-Z]", message = "Field \"Name\" must contain only latin letters")
    private String name;


    @NotEmpty(message = "Field \"Surname\" must not be empty")
    @Size(min = 2, max = 20, message = "\"Surname\" length must be from 2 to 20")
    @Pattern(regexp = "[a-zA-Z]", message = "Field \"Surname\" must contain only latin letters")
    private String surname;


    @Size(min = 2, max = 50, message = "\"Patronymic\" length must be from 2 to 20")
    @Pattern(regexp = "[a-zA-Z]", message = "Field \"Patronymic\" must contain only latin letters")
    private String patronymic;


    @NotNull(message = "Field \"Gender\" must not be empty")
    @Min(value = 0, message = "Field \"Gender\" must not be 0 or 1")
    @Max(value = 1, message = "Field \"Gender\" must not be 0 or 1")
    private Integer genderName;


    @NotNull(message = "Field \"Birth Date\" must not be empty\"")
    private Date birthDate;


    @NotNull(message = "Field \"Department\" must not be empty\"")
    @Positive(message = "\"Department\" must be positive")
    private Long idDepartment;


    @NotNull(message = "Field \"Position\" must not be empty\"")
    @Positive(message = "\"Position\" must be positive")
    private Long idPosition;


    @NotNull(message = "Field \"Grade\" must not be empty\"")
    @Positive(message = "\"Grade\" must be positive")
    private Long grade;


    @NotNull(message = "Field \"Salary\" must not be empty\"")
    @Positive
    private BigDecimal salary;


    private List<Certificate> certificates;

}
