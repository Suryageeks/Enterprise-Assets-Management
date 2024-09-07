package com.eam.Fixed.Assets.controller;

import com.eam.Fixed.Assets.dto.AssetsRegistryDto;
import com.eam.Fixed.Assets.service.AssetsRegistryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/assets-registry")
public class AssetsRegistryController {
    private final AssetsRegistryService assetsRegistryService;
    @PostMapping
    public ResponseEntity<AssetsRegistryDto> createAssets(@Valid @RequestBody AssetsRegistryDto assetsRegistryDto){
        AssetsRegistryDto createAssets = assetsRegistryService.createAssets(assetsRegistryDto);
        return new ResponseEntity<>(createAssets, HttpStatus.CREATED);
    }
    @GetMapping("/{categoryId}/{subcategoryId}")
    public ResponseEntity<AssetsRegistryDto> getAssets(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("subcategoryId") Long subcategoryId
    ){
        AssetsRegistryDto getAssets = assetsRegistryService.getAssetByCategoryAndSubCategory(categoryId,subcategoryId);
        return new ResponseEntity<>(getAssets,HttpStatus.OK);
    }
    @GetMapping("/all-assets")
    public ResponseEntity<List<AssetsRegistryDto>> getAllAssets(){
        List<AssetsRegistryDto> getAllAssets = assetsRegistryService.getAllAssets();
        return new ResponseEntity<>(getAllAssets,HttpStatus.OK);
    }
}
