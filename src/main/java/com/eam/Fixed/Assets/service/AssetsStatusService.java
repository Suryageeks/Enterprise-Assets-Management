package com.eam.Fixed.Assets.service;

import com.eam.Fixed.Assets.dto.AssetsStatusDto;
import com.eam.Fixed.Assets.entity.AssetsStatus;

import java.util.List;

public interface AssetsStatusService {
    AssetsStatusDto createStatus(AssetsStatusDto assetsStatusDto);
    List<AssetsStatusDto> getAllStatus();
    AssetsStatusDto toggleIsEnable(Long id);
}
