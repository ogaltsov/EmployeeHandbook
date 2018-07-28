package org.devgroup.handbook.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "??")
public class DepartmentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    @Basic(optional = false)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "headEmployee", referencedColumnName = "id")
    private EmployeeEntity headEmployee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_department")
    private DepartmentEntity parentDepartment;
}
