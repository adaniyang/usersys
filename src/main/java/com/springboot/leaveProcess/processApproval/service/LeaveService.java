package com.springboot.leaveProcess.processApproval.service;

import com.common.Assist;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import com.springboot.leaveProcess.processApproval.pojo.form.LeaveForm;

import java.util.Map;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 14:19
 * @Modify by:
 */
public interface LeaveService {
    LeaveDomain selectLeaveInfoByObj(LeaveDomain leaveDomain);
    Map<String,Long> insertNonEmptyLeaveInfo(LeaveForm leaveForm);
    int updateNonEmptyLeaveInfo( LeaveDomain leaveDomain, Assist assist);
}
