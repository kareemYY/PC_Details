package com.kareem.PC_Details.dto.aopDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcDetailsDTOAop {


    private int id ;


    private Date dateCreated;


    private String cpuFullName;


    private short ram;


    private short ssd;


    private int hdd;


    private EmployeeAopDto employee;
}
