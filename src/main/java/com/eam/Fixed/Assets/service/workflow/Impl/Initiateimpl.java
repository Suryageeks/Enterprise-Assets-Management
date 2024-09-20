package com.eam.Fixed.Assets.service.workflow.Impl;

import com.eam.Fixed.Assets.repository.workflow.InitiateRepository;
import com.eam.Fixed.Assets.service.workflow.InitiateService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class Initiateimpl implements InitiateService {


    private final InitiateRepository initiate;

    @Override
    public List<Object[]> getInitialStatus(String assetId, String solid, String month, String year) {
        return initiate.fetchAssetInitialStatus(assetId,solid,month,year);
    }
}
