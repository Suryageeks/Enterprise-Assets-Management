package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.service.RoleStatusStrategyService;
import com.eam.Fixed.Assets.service.roleStatusMapper.CheckerRoleStatus;
import com.eam.Fixed.Assets.service.roleStatusMapper.FNAMakerRoleStatus;
import com.eam.Fixed.Assets.service.roleStatusMapper.MakerRoleStatus;
import com.eam.Fixed.Assets.utils.RoleEnum;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RoleStatusFactoryimpl{
    public RoleStatusStrategyService getRoleStatusStrategy(String roleName) {
        try {
            switch (RoleEnum.valueOf(roleName.toUpperCase())){
                case MAKER :
                    return new MakerRoleStatus();
                case CHECKER:
                    return new CheckerRoleStatus();
                case FNAMAKER:
                    return new FNAMakerRoleStatus();
                default:
                    throw new RuntimeException("Unknown Role Found" + roleName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid Role" + roleName, e);
        }
    }
}
