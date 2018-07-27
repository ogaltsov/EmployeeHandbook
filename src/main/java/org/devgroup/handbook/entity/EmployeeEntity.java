package org.devgroup.handbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "??")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @NotNull
    @Column
    private String gender;

    @NotNull
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "department")
    private DepartmentEntity department;

    @NotNull
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @NotNull
    @Column
    private int grade;

    @NotNull
    @Column
    private int salary;

}