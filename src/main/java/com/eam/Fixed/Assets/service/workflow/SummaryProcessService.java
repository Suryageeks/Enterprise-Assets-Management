package com.eam.Fixed.Assets.service.workflow;

import com.eam.Fixed.Assets.dto.SummaryProcessDto;

import java.util.List;

public interface SummaryProcessService {
    void bulkInsertOrUpdateAssets(List<Object[]> assets);
    void batchInsertAsset(List<Object[]> assets);
    void batchUpdateAssets(List<Object[]> assets);
    void batchUpdateAssetsInSendBack(List<Object[]> assets);
}
