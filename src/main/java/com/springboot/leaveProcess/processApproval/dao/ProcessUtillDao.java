package com.springboot.leaveProcess.processApproval.dao;

import com.springboot.leaveProcess.processApproval.pojo.domain.ProcessUtillDomain;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/25 10:24
 * @Modify by:
 */
@Mapper
public interface ProcessUtillDao {
    //查看是那个流程
     ProcessUtillDomain getAllProcessInfo(String processFkCode);
}
