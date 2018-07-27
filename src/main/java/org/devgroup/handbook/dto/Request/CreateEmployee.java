package org.devgroup.handbook.dto.Request;

import lombok.*;
import org.devgroup.handbook.dto.Certificate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployee {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String patronimyc;
    @NonNull
    private String genderName;
    @NonNull
    private Date birthDate;
    @NonNull
    private String departmentName;
    @NonNull
    private String positionName;
    @NonNull
    private int grade;
    @NonNull
    private BigDecimal salary;
    private List<Certificate> certificates;

}
