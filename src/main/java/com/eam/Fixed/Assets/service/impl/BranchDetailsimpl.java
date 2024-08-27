package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.BranchDetailsDto;
import com.eam.Fixed.Assets.entity.BranchDetails;
import com.eam.Fixed.Assets.mapper.BranchDetailMapper;
import com.eam.Fixed.Assets.repository.BranchRepository;
import com.eam.Fixed.Assets.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class BranchDetailsimpl implements BranchService {
    private BranchRepository branchRepository;
    @Override
    public BranchDetailsDto createBranch(BranchDetailsDto branchDetailsDto) {
        BranchDetails branchDetails = BranchDetailMapper.MAPPER.mapToBranch(branchDetailsDto);
        BranchDetails saveDetails = branchRepository.save(branchDetails);
        BranchDetailsDto saveInDB = BranchDetailMapper.MAPPER.mapToBranchDto(saveDetails);
        return saveInDB;
    }

    @Override
    public BranchDetailsDto getBranch(String solid) {
        BranchDetails branchDetails = branchRepository.findBySolId(solid).orElseThrow(() -> new RuntimeException("Sol ID did not matched"));
        return BranchDetailMapper.MAPPER.mapToBranchDto(branchDetails);
    }

    @Override
    public List<BranchDetailsDto> getAllBranches() {
        List<BranchDetails> allBranches = branchRepository.findAll();
        return allBranches.stream().map(val -> BranchDetailMapper.MAPPER.mapToBranchDto(val)).collect(Collectors.toList());
    }

    @Override
    public BranchDetailsDto updateBranch(BranchDetailsDto branchDetailsDto) {
        BranchDetails existingBranchDetails = branchRepository.findBySolId(branchDetailsDto.getSolId())
                                                        .orElseThrow(() -> new RuntimeException("Sol ID did not matched"));
        existingBranchDetails.setBranchName(branchDetailsDto.getBranchName());
        existingBranchDetails.setBranchType(branchDetailsDto.getBranchType());
        BranchDetails updateDetails = branchRepository.save(existingBranchDetails);
        return BranchDetailMapper.MAPPER.mapToBranchDto(updateDetails);
    }
}
