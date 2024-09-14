package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.AssetsStatusDto;
import com.eam.Fixed.Assets.entity.AssetsStatus;
import com.eam.Fixed.Assets.mapper.AssetsStatusMapper;
import com.eam.Fixed.Assets.repository.AssetsStatusRepository;
import com.eam.Fixed.Assets.service.AssetsStatusService;
import com.eam.Fixed.Assets.utils.StatusEnum;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Transactional
public class AssetsStatusimpl implements AssetsStatusService {
    private AssetsStatusRepository assetsStatusRepository;
    @Override
    public AssetsStatusDto createStatus(AssetsStatusDto assetsStatusDto) {
        AssetsStatus createStatus = AssetsStatusMapper.MAPPER.mapToAssetStatus(assetsStatusDto);
        AssetsStatus saveStatus = assetsStatusRepository.save(createStatus);
        return AssetsStatusMapper.MAPPER.mapToAssetStatusDto(saveStatus);
    }

    @Override
    public List<AssetsStatusDto> getAllStatus() {
        List<AssetsStatus> getAllStatus = assetsStatusRepository.findAll();
        return getAllStatus.stream().map(val -> AssetsStatusMapper.MAPPER.mapToAssetStatusDto(val)).collect(Collectors.toList());
    }

    @Override
    public AssetsStatusDto toggleIsEnable(Long id) {
        AssetsStatus getStatus = assetsStatusRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Asset Status Id Not Available")
        );
        if(getStatus.getIsEnabled() == StatusEnum.ACTIVE){
            getStatus.setIsEnabled(StatusEnum.INACTIVE);
        }
        else{
            getStatus.setIsEnabled(StatusEnum.ACTIVE);
        }
        AssetsStatus updateStatus = assetsStatusRepository.save(getStatus);
        return AssetsStatusMapper.MAPPER.mapToAssetStatusDto(updateStatus);
    }
}
