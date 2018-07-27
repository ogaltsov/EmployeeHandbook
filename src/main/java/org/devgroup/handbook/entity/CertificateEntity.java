package org.devgroup.handbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "??")
public class CertificateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "employee")
    private EmployeeEntity employee;

    @Column(name = "name")
    private  String name;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "company")
    private String company;

    @Column(name = "number")
    private String number;

    @Column(name = "scan")
    private Blob scan;

}
