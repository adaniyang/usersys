package com.springboot.leaveProcess.processApproval.service.impl;

import com.common.Assist;
import com.common.SnowFlake;
import com.springboot.leaveProcess.processApproval.dao.LeaveDao;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import com.springboot.leaveProcess.processApproval.pojo.form.LeaveForm;
import com.springboot.leaveProcess.processApproval.service.LeaveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 14:21
 * @Modify by:
 */
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveDao leaveDao;

    @Override
    public LeaveDomain selectLeaveInfoByObj(LeaveDomain leaveDomain) {
        return leaveDao.selectLeaveInfoByObj(leaveDomain);
    }

    @Override
    public Map<String,Long> insertNonEmptyLeaveInfo(LeaveForm leaveForm) {
        Map<String,Long> result = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        LeaveDomain leaveDomain = new LeaveDomain();
        BeanUtils.copyProperties(leaveForm,leaveDomain);
        Long fkCode = SnowFlake.getId();
        leaveDomain.setFkCode(fkCode);
        leaveDomain.setUserFkCode(Long.parseLong(leaveForm.getUserFkCode()));
        leaveDomain.setCreateTime(new Date());
        leaveDomain.setUpdateTime(new Date());
        try {
            leaveDomain.setLeaveStartTime(sdf.parse(leaveForm.getLeaveStartTime()));
            leaveDomain.setLeaveEndTime(sdf.parse(leaveForm.getLeaveEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int i = leaveDao.insertNonEmptyLeaveInfo(leaveDomain);
        result.put("result",(long)i);
        result.put("fkCode",fkCode);
        return result;
    }

    @Override
    public int updateNonEmptyLeaveInfo(LeaveDomain leaveDomain, Assist assist) {
        return leaveDao.updateNonEmptyLeaveInfo(leaveDomain,assist);
    }
}
