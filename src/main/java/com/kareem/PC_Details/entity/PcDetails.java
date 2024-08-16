package com.kareem.PC_Details.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pc_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PcDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "data_created")
    private Date dateCreated;

    @Column(name = "cpu_full_name")
    private String cpuFullName;

    @Column(name = "ram")
    private short ram;

    @Column(name = "ssd")
    private int ssd;

    @Column(name = "hdd")
    private int hdd;




    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            ,fetch = FetchType.EAGER,mappedBy = "pcDetails")
    private List<MaintenanceData> maintenanceData;




    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private Employee employee;









}
