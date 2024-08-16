package com.kareem.PC_Details.dto.aopDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcLogsDto {

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
