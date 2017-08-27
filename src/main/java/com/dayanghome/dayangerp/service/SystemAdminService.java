package com.dayanghome.dayangerp.service;

import com.dayanghome.dayangerp.mapper.SystemAdminMapper;
import com.dayanghome.dayangerp.vo.SystemAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.google.common.base.Preconditions.checkState;

@Service
public class SystemAdminService {
    @Autowired private SystemAdminMapper systemAdminMapper;


    @Transactional
    public int addNewSystemAdmin(SystemAdmin admin){
        checkState(systemAdminMapper.insertSystemAdmin(admin) == 1,
        "add new system admin failed");

        return admin.getId();
    }

    @Transactional
    public int activateAdminUser(Integer systemAdminId){
        return systemAdminMapper.activateSystemAdmin(systemAdminId);
    }

    public SystemAdmin verigySystemAdmin(SystemAdmin admin){
        return systemAdminMapper.verifySystemAdminLogin(admin);
    }
}
