package com.kareem.PC_Details.service;




import com.kareem.PC_Details.dto.branch.BranchDto;

import java.util.List;

public interface BranchService {

    List<BranchDto> getAllBranches();

    BranchDto getOnebranch(int branchId);
}
