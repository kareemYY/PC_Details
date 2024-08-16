package com.kareem.PC_Details.dto.aopDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeAopDto {

    private int companyEmployeeId;
    
    private BranchAopDto branch;
}
