package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.AssetBarcodeDto;

public interface AssetBarcodeService {
    byte[] barcodeGeneration(String assetId);
    AssetBarcodeDto barcodeCreation(AssetBarcodeDto assetBarcodeDto);
    AssetBarcodeDto checkerApprover(AssetBarcodeDto assetBarcodeDto);
}
