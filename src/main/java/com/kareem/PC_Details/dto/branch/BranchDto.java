package com.kareem.PC_Details.dto.branch;

import lombok.Data;
import java.util.List;


@Data
public class BranchDto {

    private int companyBranchId;

    private String branchNameArabic;

    private SupervisorDtoBranch supervisor;

    private GovernorateDtoBranch governorate;

    List<EmployeeDtoBranch> employees;

}
