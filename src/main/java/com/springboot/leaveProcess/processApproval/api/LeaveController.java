package com.springboot.leaveProcess.processApproval.api;

import com.common.Assist;
import com.common.vo.Result;
import com.springboot.activiCommon.commom.ProcessUtil;
import com.springboot.activiCommon.pojo.form.TaskOverVo;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import com.springboot.leaveProcess.processApproval.pojo.form.LeaveForm;
import com.springboot.leaveProcess.processApproval.pojo.vo.LeaveVo;
import com.springboot.leaveProcess.processApproval.service.LeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 14:27
 * @Modify by:
 */
@Api(tags = "请假流程",description = "请假流程新增查询操作")
@RestController
@RequestMapping("/leaveProcessOperate")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private ProcessUtil processUtil;

    @ApiOperation(value = "第一步：新增一个请假单")
    @PostMapping("/addLeaveProcess")
    private Result addLeaveProcess(@RequestBody LeaveForm leaveForm){
        Map<String,Long> result = leaveService.insertNonEmptyLeaveInfo(leaveForm);
        long i = result.get("result");
        if(i != 0){
            return new Result("success","创建请假单成功",result.get("fkCode"));
        }else{
            return new Result("error","创建请假单失败",i);
        }
    }

    @ApiOperation(value = "第二步：通过流程id和请假单,启动流程")
    @GetMapping("/startleaveProcess")
    private Result startleaveProcess(@ApiParam(value = "流程id") @RequestParam String processId,@ApiParam(value = "请假单外键") @RequestParam  String leaveProcessFkCode){
        //修改请假表的请假状态、启动状态、流程id
        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("FK_CODE",leaveProcessFkCode));
        LeaveDomain leaveDomain = new LeaveDomain();
        leaveDomain.setUpdateTime(new Date());
        leaveDomain.setStatus(1);
        leaveDomain.setStartStatus(1);
//        leaveDomain.setProcessId(Long.parseLong(processId));
        int i = leaveService.updateNonEmptyLeaveInfo(leaveDomain,assist);
        if(i != 0){
            processUtil.startProcess(processId,leaveProcessFkCode);
            return new Result("suceess","请假单启动成功",null);
        }else {
            return new Result("erro","请假单启动失败",null);
        }
    }

    @Autowired
    private RuntimeService runtimeService;

    @ApiOperation(value = "第三步：通过用户外键获取任务" )
    @GetMapping("/findPersonTask")
    public Result findPersonTask(@ApiParam(value = "用户外键") @RequestParam String userFkCode){
        List<Task> taskList = processUtil.findTaskByUserId(userFkCode);
        List<LeaveVo> leaveVoList = new ArrayList<>();

        for(Task task :taskList){
            //通过给定的id(任务执行id)查询流程实例
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getExecutionId()).singleResult();
            //获取流程实例的业务外键
            String leaveFkCode = processInstance.getBusinessKey();
            System.out.println("业务外键-processInstance.getBusinessKey() is :" + leaveFkCode);
            //通过业务流程外键找到该条记录，设置processId
            LeaveDomain leaveDomainAssist = new LeaveDomain();
            leaveDomainAssist.setFkCode(Long.parseLong(leaveFkCode));
            leaveDomainAssist.setDeleteStatus(1);
            LeaveDomain leaveDomain = leaveService.selectLeaveInfoByObj(leaveDomainAssist);
            System.out.println("task.id 为：" + task.getId());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            LeaveVo leaveVo = new LeaveVo();
            BeanUtils.copyProperties(leaveDomain,leaveVo);
            leaveVo.setFkCode(leaveDomain.getFkCode().toString());
            leaveVo.setUserFkCode(leaveDomain.getUserFkCode().toString());
            leaveVo.setProcessId(task.getId());
            leaveVo.setLeaveStartTime(sdf.format(leaveDomain.getLeaveStartTime()));
            leaveVo.setLeaveEndTime(sdf.format(leaveDomain.getLeaveEndTime()));
            leaveVo.setCreateTime(sdf.format(leaveDomain.getCreateTime()));
            leaveVo.setUserFkCode(sdf.format(leaveDomain.getUpdateTime()));
            leaveVoList.add(leaveVo);

            //修改业务外键对应的记录的processId
            LeaveDomain needUpdateLeaveDomain = new LeaveDomain();
            needUpdateLeaveDomain.setProcessId(Long.parseLong(task.getId()));
            needUpdateLeaveDomain.setUpdateTime(new Date());
            Assist assist = new Assist();
            assist.setRequires(Assist.andEq("FK_CODE",leaveFkCode));
            assist.setRequires(Assist.andEq("DELETE_STATUS",1));
            leaveService.updateNonEmptyLeaveInfo(needUpdateLeaveDomain,assist);
        }
        return new Result("success","请求成功",leaveVoList);
    }

    @ApiOperation("第四步：完成这个流程")
    @PostMapping("/completeTask")
    public Result completeTask(@RequestBody TaskOverVo taskOverVo){
        processUtil.completeTaskByUser(taskOverVo);
        return new Result("success","请求成功",null);
    }
}
