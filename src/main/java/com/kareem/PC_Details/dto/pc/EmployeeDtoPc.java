package com.kareem.PC_Details.dto.pc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDtoPc {

    private int companyEmployeeId;
    private String fullNameArabic;
    private String phoneNum;

    private BranchDtoPc branch;
}
