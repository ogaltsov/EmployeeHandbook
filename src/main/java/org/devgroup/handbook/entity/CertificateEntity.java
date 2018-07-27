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
    @Column(name = "employee", nullable = false)
    private EmployeeEntity employee;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "scan")
    private Blob scan;

}
