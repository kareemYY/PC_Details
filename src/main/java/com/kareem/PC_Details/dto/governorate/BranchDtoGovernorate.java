package com.kareem.PC_Details.dto.governorate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDtoGovernorate {

    private int companyBranchId;

    private String branchNameArabic;




    private List<EmployeeDtoGovernorate> employees;


}
