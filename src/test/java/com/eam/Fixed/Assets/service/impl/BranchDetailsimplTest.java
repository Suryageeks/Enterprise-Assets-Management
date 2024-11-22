package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.BranchDetailsDto;
import com.eam.Fixed.Assets.entity.BranchDetails;
import com.eam.Fixed.Assets.repository.BranchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BranchDetailsimplTest {
    @InjectMocks
    private BranchDetailsimpl branchDetailsimpl;
    @Mock
    private BranchRepository branchRepository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createBranch() {
        BranchDetails branchDetails = new BranchDetails(1L,"200","kolkata","atm",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        BranchDetailsDto branchDetailsDto = new BranchDetailsDto(1L,"200","kolkata","atm");
        when(
                branchRepository.save(any(BranchDetails.class))
        ).thenReturn(branchDetails);
        BranchDetailsDto createBranch = branchDetailsimpl.createBranch(branchDetailsDto);
        assertNotNull(createBranch);
        assertEquals(createBranch.getId(),branchDetails.getId());
        assertEquals(createBranch.getBranchName(),branchDetails.getBranchName());
    }

    @Test
    void getBranch() {
        BranchDetails branchDetails = new BranchDetails(1L,"200","kolkata","atm",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                branchRepository.findBySolId("200")
        ).thenReturn(Optional.of(branchDetails));
        BranchDetailsDto getBranch = branchDetailsimpl.getBranch("200");
        assertNotNull(getBranch);
        assertEquals(getBranch.getId(),branchDetails.getId());
        assertEquals(getBranch.getBranchName(),branchDetails.getBranchName());
    }

    @Test
    void getAllBranches() {
        BranchDetails branchDetails = new BranchDetails(1L,"200","kolkata","atm",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        BranchDetails branchDetails1 = new BranchDetails(1L,"201","CIT ROAD","branch",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                branchRepository.findAll()
        ).thenReturn(Arrays.asList(branchDetails,branchDetails1));
        List<BranchDetailsDto> getAllBranches = branchDetailsimpl.getAllBranches();
        assertNotNull(getAllBranches);
        assertEquals(getAllBranches.size(),2);
        assertEquals(getAllBranches.get(0).getBranchName(),branchDetails.getBranchName());
        assertEquals(getAllBranches.get(1).getBranchName(),branchDetails1.getBranchName());
        assertEquals(getAllBranches.get(1).getBranchType(),branchDetails1.getBranchType());
        verify(branchRepository).findAll();
    }

    @Test
    void updateBranch() {
        BranchDetails branchDetails = new BranchDetails(1L,"200","kolkata","atm",new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        BranchDetailsDto branchDetailsDto = new BranchDetailsDto(1L,"200","kolkata","branch");
        when(
                branchRepository.findBySolId("200")
        ).thenReturn(Optional.of(branchDetails));
        when(
                branchRepository.save(any(BranchDetails.class))
        ).thenReturn(branchDetails);
        BranchDetailsDto updateBranch = branchDetailsimpl.updateBranch(branchDetailsDto);
        assertEquals(updateBranch.getId(),branchDetails.getId());
        assertEquals(updateBranch.getBranchName(),branchDetails.getBranchName());
        assertEquals(updateBranch.getBranchType(),branchDetailsDto.getBranchType());
        verify(branchRepository,times(1)).findBySolId("200");
    }
}