package com.springboot.activiti.service.serviceImpl;

import com.common.Assist;
import com.common.SnowFlake;
import com.springboot.activiti.commom.ProcessUtil;
import com.springboot.activiti.dao.LeaveInfoDao;
import com.springboot.activiti.domain.LeaveInfo;
import com.springboot.activiti.domain.vo.LeaveInfoForm;
import com.springboot.activiti.domain.vo.TaskOverVo;
import com.springboot.activiti.service.SchoolService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    LeaveInfoDao leaveInfoDao;
    @Autowired
    ProcessUtil processUtil;
    @Autowired
    RuntimeService runtimeService;

    /**
     * @Param:描述:新增请假单,并启动流程
     * @return：返回结果描述:
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-4-26 11:15
     */
    @Override
    public int addLeaveInfo(LeaveInfoForm msg) {
        //请假单id
        long fkcode = SnowFlake.getId();
        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setFkCode(fkcode);
        leaveInfo.setCreateTime(new Date());
        leaveInfo.setUpdateTime(new Date());
        leaveInfo.setDelStatus(0);
        leaveInfo.setStatus("草稿");
        leaveInfo.setLeaveMsg(msg.getLeaveMsg());
        leaveInfo.setLeaveName(msg.getLeaveName());
        leaveInfo.setLeaveUserFkCode(Long.parseLong(msg.getLeaveUserFkCode()));
        leaveInfo.setLeaveType(msg.getLeaveType());
        int i = leaveInfoDao.insertNonEmptyLeaveInfo(leaveInfo);
        return i;
    }

    /**
    * @Param:描述:查询自己的待办任务
    * @return：返回结果描述:
    * @Throws：返回异常结果:
    * @Author: chenshangxian
    * @Date: 2018-4-26 15:18
    */
    @Override
    public List<LeaveInfo> queryByUserId(String userFkCode) {
        //查询相关审批人
        List<Task> taskByUserId = processUtil.findTaskByUserId(userFkCode);
        ArrayList<LeaveInfo> leaveInfos = new ArrayList<>();
        for (Task task : taskByUserId) {
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getExecutionId()).singleResult();
            //得到业务单据号,这里就是请假单外键
            String businessKey = processInstance.getBusinessKey();
            //这里只能查询删除状态为0的单
            Assist assist = new Assist();
            assist.setRequires(Assist.andEq("DEL_STATUS",0));
            assist.setRequires(Assist.andEq("FK_CODE",businessKey));
            //LeaveInfo leaveInfo = new LeaveInfo();
            //leaveInfo.setFkCode(Long.parseLong(businessKey));
            //通过请假单外键查询出一个请假单
            List<LeaveInfo> leaveInfos1 = leaveInfoDao.selectLeaveInfo(assist);
            for (LeaveInfo info : leaveInfos1) {
                //获得业务单据号(这个用于审批通过与否用的)
                info.setProcessId(Long.parseLong(task.getId()));
                leaveInfos.add(info);
            }
        }
        return leaveInfos;
    }

    /**
    * @Param:描述:完成自己的待办任务
    * @return：返回结果描述:
    * @Throws：返回异常结果:
    * @Author: chenshangxian
    * @Date: 2018-4-26 15:18
    */
    @Override
    public void completeTaskByUser(TaskOverVo taskOverVo) {
        processUtil.completeTaskByUser(taskOverVo);
    }
}
