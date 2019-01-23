package com.springboot.leaveProcess.processApproval.dao;

import com.common.Assist;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 11:53
 * @Modify by:
 */
@Mapper
public interface LeaveDao {
    LeaveDomain selectLeaveInfoByObj(LeaveDomain leaveDomain);
    int insertNonEmptyLeaveInfo(LeaveDomain leaveDomain);
    int updateNonEmptyLeaveInfo(@Param("enti") LeaveDomain leaveDomain, @Param("assist") Assist assist);
}
