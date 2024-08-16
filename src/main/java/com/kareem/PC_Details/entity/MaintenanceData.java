package com.kareem.PC_Details.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "maintenance_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLogs;

    @Column (name = "date")
    private Date date;

    @Column(name = "report")
    private String report;



    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    @JoinColumn(name = "pcData_id")
    private PcDetails pcDetails;

}
