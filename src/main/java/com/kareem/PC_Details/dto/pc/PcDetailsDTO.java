package com.kareem.PC_Details.dto.pc;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcDetailsDTO {


    private int id ;


    private Date dateCreated;


    private String cpuFullName;


    private short ram;


    private int ssd;


    private int hdd;



}
