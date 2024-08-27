package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.BranchDetailsDto;

import java.util.List;


public interface BranchService {
    BranchDetailsDto createBranch(BranchDetailsDto branchDetailsDto);
    BranchDetailsDto getBranch(String solid);
    List<BranchDetailsDto> getAllBranches();
    BranchDetailsDto updateBranch(BranchDetailsDto branchDetailsDto);

}
