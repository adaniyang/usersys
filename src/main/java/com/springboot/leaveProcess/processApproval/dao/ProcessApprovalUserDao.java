package com.springboot.leaveProcess.processApproval.dao;

import com.common.Assist;
import com.springboot.leaveProcess.processApproval.pojo.domain.ProcessApprovalUserDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 11:53
 * @Modify by:
 */
@Mapper
public interface ProcessApprovalUserDao {
    List<ProcessApprovalUserDomain> selectProcessApprovalUser(Assist assist);

}
