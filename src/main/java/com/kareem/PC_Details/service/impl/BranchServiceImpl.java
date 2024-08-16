package com.kareem.PC_Details.service.impl;


import com.kareem.PC_Details.dto.branch.BranchDto;
import com.kareem.PC_Details.entity.Branch;
import com.kareem.PC_Details.exception.ResourceNotFound;
import com.kareem.PC_Details.repository.BranchRepository;
import com.kareem.PC_Details.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {


    private BranchRepository branchRepository;
    private ModelMapper mapper;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, ModelMapper mapper) {
        this.branchRepository = branchRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BranchDto> getAllBranches() {
        List<Branch> branches= branchRepository.findAll();
        List<BranchDto> branchDtos= branches.stream().map(branch -> mapper.map(branch,BranchDto.class)).toList();
        return branchDtos;
    }

    @Override
    public BranchDto getOnebranch(int branchId) {
        Branch branch= branchRepository.findById(branchId).
                orElseThrow(() -> new ResourceNotFound("Branch Id Not Found"));
        return mapper.map(branch,BranchDto.class);
    }
}
