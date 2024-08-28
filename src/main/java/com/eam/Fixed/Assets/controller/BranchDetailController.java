package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.BranchDetailsDto;
import com.eam.Fixed.Assets.service.BranchService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/branch")
public class BranchDetailController {
    private BranchService branchService;
    @PostMapping
    public ResponseEntity<BranchDetailsDto> createBranch(@Valid @RequestBody BranchDetailsDto branchDetailsDto){
        BranchDetailsDto saveBranch = branchService.createBranch(branchDetailsDto);
        return new ResponseEntity<>(saveBranch, HttpStatus.CREATED);
    }
    @GetMapping("allbranch")
    public ResponseEntity<List<BranchDetailsDto>> getAllBranch(){
        List<BranchDetailsDto> allBranch = branchService.getAllBranches();
        return new ResponseEntity<>(allBranch,HttpStatus.OK);
    }
    @GetMapping("{solid}")
    public ResponseEntity<BranchDetailsDto> getBranch(@PathVariable("solid") String solid){
        BranchDetailsDto branch = branchService.getBranch(solid);
        return new ResponseEntity<>(branch,HttpStatus.OK);
    }

//    @PutMapping("update/{solid}")
//    public ResponseEntity<BranchDetailsDto> updateBranch(@Valid @PathVariable("solid") String solid,@RequestBody BranchDetailsDto branch){
//        branch.setSolId(solid);
//        BranchDetailsDto update = branchService.updateBranch(branch);
//        return new ResponseEntity<>(update,HttpStatus.OK);
//    }

}
