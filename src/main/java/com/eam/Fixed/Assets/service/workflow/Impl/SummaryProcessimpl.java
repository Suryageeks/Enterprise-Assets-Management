package com.eam.Fixed.Assets.service.workflow.Impl;

import com.eam.Fixed.Assets.entity.SummaryProcess;
import com.eam.Fixed.Assets.repository.workflow.SummaryProcessRepository;
import com.eam.Fixed.Assets.service.RoleStatusStrategyService;
import com.eam.Fixed.Assets.service.impl.RoleStatusFactoryimpl;
import com.eam.Fixed.Assets.service.workflow.SummaryProcessService;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class SummaryProcessimpl implements SummaryProcessService {

    @Autowired
    private final SummaryProcessRepository summaryProcessRepository;
    @Autowired
    private final RoleStatusFactoryimpl roleStatusFactory;

    @Override
    @Modifying
    public void bulkInsertOrUpdateAssets(List<Object[]> assets) {
        Set<String> assetIds = assets.stream().map(asset -> asset[0].toString()).collect(Collectors.toSet());

        Set<String> existingAssetId = summaryProcessRepository.findExistingAssetId(assetIds);

        List<Object[]> newAssets = new ArrayList<>();
        List<Object[]> existingAssets = new ArrayList<>();

        for(Object[] asset: assets) {
            String assetId = asset[0].toString();
            if(existingAssetId.contains(assetId)){
                existingAssets.add(asset);
            }else{
                newAssets.add(asset);
            }
        }

        if(!existingAssets.isEmpty()){
            batchUpdateAssets(existingAssets);
        }
        if(!newAssets.isEmpty()){
            batchInsertAsset(newAssets);
        }

    }

    public void batchInsertAsset(List<Object[]> assets){
        List<SummaryProcess> summaryProcesses = assets.stream()
                .map(asset -> {
                    SummaryProcess summaryProcess = new SummaryProcess();
                    summaryProcess.setAssetId(asset[0].toString());
                    summaryProcess.setAssetName(asset[1].toString());
                    summaryProcess.setSolId(asset[2].toString());
                    summaryProcess.setBranchName(asset[3].toString());
                    summaryProcess.setMakerId(asset[4].toString());
                    summaryProcess.setMakerName(asset[5].toString());
                    summaryProcess.setCheckerId(asset[6].toString());
                    summaryProcess.setCheckerName(asset[7].toString());
                    summaryProcess.setFnaId(asset[8].toString());
                    summaryProcess.setFnaMaker(asset[9].toString());
                    summaryProcess.setReconciliationType(asset[10].toString());
                    summaryProcess.setStatus(WorkflowStatusEnum.PC);
                    summaryProcess.setMonth(asset[11].toString());
                    summaryProcess.setYear(asset[12].toString());
                    return summaryProcess;
                }).collect(Collectors.toList());

        summaryProcessRepository.saveAll(summaryProcesses);
    }

    private HttpSession session;

    public void batchUpdateAssets(List<Object[]> assets){
        assets.forEach(
                asset -> {
                    WorkflowStatusEnum status = WorkflowStatusEnum.valueOf(asset[4].toString());
                    if(status == WorkflowStatusEnum.PC){
                        status = WorkflowStatusEnum.PFM;
                    }
                    else if (status == WorkflowStatusEnum.PFM) {
                        status = WorkflowStatusEnum.END;
                    }
                    summaryProcessRepository.bulkUpdateAsset(
                            asset[0].toString(),
                            asset[1].toString(),
                            asset[2].toString(),
                            asset[3].toString(),
                            status,
                            asset[5].toString(),
                            asset[6].toString(),
                            asset[7].toString(),
                            asset[8].toString(),
                            asset[9].toString(),
                            asset[10].toString(),
                            asset[11].toString(),
                            asset[12].toString()
                    );
                }
        );
    }

    public void batchUpdateAssetsInSendBack(List<Object[]> assets){
        assets.forEach(
                asset -> {
                    summaryProcessRepository.bulkUpdateAsset(
                            asset[0].toString(),
                            asset[1].toString(),
                            asset[2].toString(),
                            asset[3].toString(),
                            WorkflowStatusEnum.SB,
                            asset[5].toString(),
                            asset[6].toString(),
                            asset[7].toString(),
                            asset[8].toString(),
                            asset[9].toString(),
                            asset[10].toString(),
                            asset[11].toString(),
                            asset[12].toString()
                    );
                }
        );
    }

    @Override
    public List<Object[]> getAssetsByStatus(String month, String year) {
        String role = (String) session.getAttribute("role");
        String sol = (String) session.getAttribute("solid");
        if(role == null || role.isEmpty()){
            throw new RuntimeException("Role Name Not Found !!");
        }
        if(sol == null || sol.isEmpty()){
            throw new RuntimeException("Sol ID Not Found !!");
        }

        RoleStatusStrategyService strategy = roleStatusFactory.getRoleStatusStrategy(role);
        List<String> status = strategy.getRoleStatus();
        
        return summaryProcessRepository.findExistingAssetByStatus(status, month, year, sol);
    }

}
