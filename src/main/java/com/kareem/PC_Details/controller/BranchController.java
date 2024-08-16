package com.kareem.PC_Details.controller;



import com.kareem.PC_Details.dto.branch.BranchDto;
import com.kareem.PC_Details.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    private BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public List<BranchDto> getAllBranches(){
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public BranchDto getOneBranch(@PathVariable ("id") int id){
        return branchService.getOnebranch(id);
    }

















}
