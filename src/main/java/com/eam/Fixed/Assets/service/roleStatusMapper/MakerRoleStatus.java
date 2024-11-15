package com.eam.Fixed.Assets.service.roleStatusMapper;

import com.eam.Fixed.Assets.service.RoleStatusStrategyService;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;

import java.util.Arrays;
import java.util.List;

public class MakerRoleStatus implements RoleStatusStrategyService {

    @Override
    public List<String> getRoleStatus() {
        return Arrays.asList(WorkflowStatusEnum.PM.name(),WorkflowStatusEnum.SB.name());
    }
}
