package com.kareem.PC_Details.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int PcId;

    private int branchId;

    private int employeeId;

    private Date dateStart;

    private Date dateEnd;

    private String cpuFullName;

    private short ssd;

    private int hdd;

    private short ram;


}
