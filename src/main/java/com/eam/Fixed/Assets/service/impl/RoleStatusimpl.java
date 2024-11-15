package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.service.RoleStatusService;
import com.eam.Fixed.Assets.utils.RoleEnum;
import com.eam.Fixed.Assets.utils.WorkflowStatusEnum;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RoleStatusimpl implements RoleStatusService {
    @Override
    public List<String> getRoleStatus(String roleName) {
        try {
            switch (RoleEnum.valueOf(roleName.toUpperCase())){
                case MAKER :
                    return Arrays.asList(WorkflowStatusEnum.PM.name(),WorkflowStatusEnum.SB.name());
                case CHECKER:
                    return Collections.singletonList(WorkflowStatusEnum.PC.name());
                case FNAMAKER:
                    return Collections.singletonList(WorkflowStatusEnum.PFM.name());
                default:
                    throw new RuntimeException("Unknown Role Found" + roleName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid Role" + roleName, e);
        }
    }
}
