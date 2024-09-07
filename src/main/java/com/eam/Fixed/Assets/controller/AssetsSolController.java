package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.AssetsSolDto;
import com.eam.Fixed.Assets.service.AssetsSolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/asset-sol-map")
public class AssetsSolController {
    private AssetsSolService assetsSolService;
    @PostMapping
    public ResponseEntity<AssetsSolDto> mapAssets(@Valid @RequestBody AssetsSolDto assetsSolDto){
        AssetsSolDto mappingAssets = assetsSolService.mapAssetsSol(assetsSolDto);
        return new ResponseEntity<>(mappingAssets, HttpStatus.CREATED);
    }
    @GetMapping("/{assetId}")
    public ResponseEntity<AssetsSolDto> getMappedAssets(@PathVariable("assetId") Long assetId){
        AssetsSolDto mappedAssets = assetsSolService.getAssetSolMap(assetId);
        return new ResponseEntity<>(mappedAssets,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssetsSolDto> updateMappedAssets(@PathVariable("id") Long id,AssetsSolDto assetsSolDto){
        AssetsSolDto updateAssets = assetsSolService.updateAssetSolMap(id,assetsSolDto);
        return new ResponseEntity<>(updateAssets,HttpStatus.OK);
    }
}
