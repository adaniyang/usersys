package com.springboot.activiti.service;

import com.springboot.activiti.domain.LeaveInfo;
import com.springboot.activiti.domain.vo.LeaveInfoForm;
import com.springboot.activiti.domain.vo.TaskOverVo;

import java.util.List;

public interface SchoolService {
    int addLeaveInfo(LeaveInfoForm msg);

    List<LeaveInfo> queryByUserId(String userFkCode);

    void completeTaskByUser(TaskOverVo taskOverVo);
}
