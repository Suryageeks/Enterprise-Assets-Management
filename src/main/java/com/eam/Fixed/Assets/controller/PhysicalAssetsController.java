package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.PhysicalAssetsDto;
import com.eam.Fixed.Assets.service.PhysicalAssetsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/physical-assets")
@AllArgsConstructor
public class PhysicalAssetsController {
    private PhysicalAssetsService physicalAssetsService;
    @PostMapping
    public ResponseEntity<PhysicalAssetsDto> createAsset(@Valid @RequestBody PhysicalAssetsDto physicalAssetsDto){
        PhysicalAssetsDto createAsset = physicalAssetsService.createAssets(physicalAssetsDto);
        return new ResponseEntity<>(createAsset, HttpStatus.CREATED);
    }
    @GetMapping("/all-asset")
    public ResponseEntity<List<PhysicalAssetsDto>> getAllAsset(){
        List<PhysicalAssetsDto> getAllAsset = physicalAssetsService.getAllAssets();
        return new ResponseEntity<>(getAllAsset,HttpStatus.OK);
    }
    @PutMapping("/update-asset/{assetId}")
    public ResponseEntity<PhysicalAssetsDto> updateAsset(@PathVariable("assetId") String assetId,@Valid @RequestBody PhysicalAssetsDto physicalAssetsDto) {
        PhysicalAssetsDto updateAsset = physicalAssetsService.updateAssets(assetId, physicalAssetsDto);
        return new ResponseEntity<>(updateAsset, HttpStatus.OK);
    }
    @GetMapping("/all-asset-sol/{solId}")
    public ResponseEntity<List<PhysicalAssetsDto>> getAssetBySol(@PathVariable("solId") Long solId){
        List<PhysicalAssetsDto> getAllAssetBySol = physicalAssetsService.getAssetsBySolId(solId);
        return new ResponseEntity<>(getAllAssetBySol,HttpStatus.OK);
    }
}
