package org.devgroup.handbook.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @NonNull
    private long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String patronimyc;
    @NonNull
    private String gender;
    @NonNull
    private Date birthDate;
    @NonNull
    private Department department;
    @NonNull
    private Position position;
    @NonNull
    private int grade;
    @NonNull
    private BigDecimal salary;
    private List<Certificate> certificates;

}
