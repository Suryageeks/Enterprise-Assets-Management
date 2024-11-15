package com.eam.Fixed.Assets.service.roleStatusMapper;

import com.eam.Fixed.Assets.service.RoleStatusStrategyService;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;

import java.util.Collections;
import java.util.List;

public class CheckerRoleStatus implements RoleStatusStrategyService {
    @Override
    public List<String> getRoleStatus() {
        return Collections.singletonList(WorkflowStatusEnum.PC.name());
    }
}
