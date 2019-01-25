package com.springboot.activiCommon.commom;

import com.common.Assist;
import com.springboot.activiCommon.pojo.form.TaskOverVo;
import com.springboot.leaveProcess.processApproval.dao.LeaveDao;
import com.springboot.leaveProcess.processApproval.dao.ProcessApprovalUserDao;
import com.springboot.leaveProcess.processApproval.dao.ProcessUtillDao;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import com.springboot.leaveProcess.processApproval.pojo.domain.ProcessApprovalUserDomain;
import com.springboot.leaveProcess.processApproval.pojo.domain.ProcessUtillDomain;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Param:描述:activiti工具类
 * @return：返回结果描述:
 * @Throws：返回异常结果:
 * @Author: adayang
 * @Date:2019/1/22 11:17
 */
@Service
public class ProcessUtil {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessApprovalUserDao processApprovalUserDao;
    @Autowired
    LeaveDao leaveDao;
    @Autowired
    ProcessUtillDao processUtillDao;

    //${processUtil.findNodeManager(execution,processType,level)}
    //查询n级节点的人,一级就传1，二级就传2，三级就传3，以此类推
    //DelegateExecution execution: 执行实例的代理对象
    public List<String> findNodeManager(DelegateExecution execution, String processType,Integer level) {
        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("LEVEL", level));
        assist.setRequires(Assist.andEq("PROCESS_TYPE",processType));
        List<ProcessApprovalUserDomain> processApprovalUserDomainList = processApprovalUserDao.selectProcessApprovalUser(assist);
        ArrayList<String> list = new ArrayList<>();
        processApprovalUserDomainList.forEach(e -> {
            String userFkCode = e.getUserFkCode().toString();
            list.add(userFkCode);
        });
        return list;
    }


    //启动流程
    //processId:流程的id,很重要
    //taskFkCode:请假单的fkcode
    public void startProcess(String processId,String taskFkCode) {
        runtimeService.startProcessInstanceByKey(processId, taskFkCode);
    }

    //查询相关审批人
    public List<Task> findTaskByUserId(String userFkCode) {
        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(userFkCode).list();
        return list;
    }

    //审批
    //taskFkCode:审批哪个任务(业务单据外键(不是请假单外键))
    //userFkCode:谁审批的
    //audit:通过(pass),不通过(reject)
    public void completeTaskByUser(TaskOverVo taskOverVo) {
        //认领任务
        taskService.claim(taskOverVo.getTaskFkCode(), taskOverVo.getUserFkCode());
        HashMap<String, Object> map = new HashMap<>();
        //audit必须和流程图里的值一样 如下:
        //CDATA[${audit=='pass'}]]
        map.put("audit", taskOverVo.getAduit());
        if(taskOverVo.getDay()!=null){
            map.put("day",taskOverVo.getDay());
        }
        //使流程往下走一步
        taskService.complete(taskOverVo.getTaskFkCode(), map);
    }

    //${leaveService.changeStatus(execution,'img')}
    //修改业务单据
    public void changeStatus(DelegateExecution execution, String status) {
        System.out.println("修改业务单据状态:->" + status);
        //通过各业务的外键查找是那个业务流程，然后修改不同业务的字段
        //获取各业务的外键
        String processFkCode = execution.getProcessBusinessKey();
        ProcessUtillDomain processUtillDomain = processUtillDao.getAllProcessInfo(processFkCode);
        switch (processUtillDomain.getType()){
            case "QJ":
                //执行请假的更新操作
                LeaveDomain leaveDomain = new LeaveDomain();
                leaveDomain.setStatus(Integer.parseInt(status));
                Assist assist = new Assist();
                assist.setRequires(Assist.andEq("FK_CODE", processFkCode));
                leaveDao.updateNonEmptyLeaveInfo(leaveDomain, assist);
                break;
            default:
                    break;

        }
    }
}
