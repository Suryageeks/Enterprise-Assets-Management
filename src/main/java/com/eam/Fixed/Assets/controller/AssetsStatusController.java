package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.AssetsStatusDto;
import com.eam.Fixed.Assets.service.AssetsStatusService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asset-status")
@AllArgsConstructor
public class AssetsStatusController {
    private AssetsStatusService assetsStatusService;
    @PostMapping
    public ResponseEntity<AssetsStatusDto> createAssetsStatus(@Valid @RequestBody AssetsStatusDto assetsStatusDto){
        AssetsStatusDto createStatus = assetsStatusService.createStatus(assetsStatusDto);
        return new ResponseEntity<>(createStatus, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AssetsStatusDto>> getAllStatus(){
        List<AssetsStatusDto> getStatus = assetsStatusService.getAllStatus();
        return new ResponseEntity<>(getStatus,HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AssetsStatusDto> toggleStatus(@PathVariable("id") Long id){
        AssetsStatusDto isEnable = assetsStatusService.toggleIsEnable(id);
        return new ResponseEntity<>(isEnable,HttpStatus.OK);
    }
}
