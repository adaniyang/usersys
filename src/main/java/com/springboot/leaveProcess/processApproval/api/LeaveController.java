package com.springboot.leaveProcess.processApproval.api;

import com.common.Assist;
import com.common.vo.Result;
import com.springboot.activiCommon.commom.ProcessUtil;
import com.springboot.leaveProcess.processApproval.pojo.domain.LeaveDomain;
import com.springboot.leaveProcess.processApproval.pojo.form.LeaveForm;
import com.springboot.leaveProcess.processApproval.service.LeaveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        leaveDomain.setProcessId(Long.parseLong(processId));
        int i = leaveService.updateNonEmptyLeaveInfo(leaveDomain,assist);
        if(i != 0){
            processUtil.startProcess(processId,leaveProcessFkCode);
        }
        return new Result("suceess","请假单启动成功",null);
    }

}
