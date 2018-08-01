package org.devgroup.handbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.devgroup.handbook.util.BigDecimalConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @NotNull
    @Column(name = "gender", nullable = false)
    private Integer gender;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "department", nullable = false)
    private DepartmentEntity department;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "position", nullable = false)
    private PositionEntity position;

    @NotNull
    @Column(name = "grade", nullable = false)
    private Long grade;

    @NotNull
    @Convert(converter = BigDecimalConverter.class) //convert BigDecimal to Long(123.75 <-->  12375(100))
    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

}