package com.kareem.PC_Details.dto.governorate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcDetailsDtoGovernorate {


    private int id ;


    private Date dateCreated;


    private String cpuFullName;


    private short ram;


    private int ssd;


    private int hdd;
}
