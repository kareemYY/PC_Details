package com.kareem.PC_Details.dto.governorate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDtoGovernorate {

    private int companyEmployeeId;

    private String fullNameArabic;


    private PcDetailsDtoGovernorate pcDetails;
}
