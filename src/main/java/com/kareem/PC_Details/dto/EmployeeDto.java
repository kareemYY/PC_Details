package com.kareem.PC_Details.dto;

import com.kareem.PC_Details.dto.pc.BranchDtoPc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {
    private  int EmployeeId;

    private int companyEmployeeId;

    private String fullNameEnglish;

    private String fullNameArabic;

    private String department;

    private String nationalID;

    private String phoneNum;

    private String address;

    private BranchDtoPc branch;
}
