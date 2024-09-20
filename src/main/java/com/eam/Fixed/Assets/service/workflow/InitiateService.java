package com.eam.Fixed.Assets.service.workflow;

import java.util.List;

public interface InitiateService {

    List<Object[]> getInitialStatus(String assetId, String solid, String month, String year);
}
