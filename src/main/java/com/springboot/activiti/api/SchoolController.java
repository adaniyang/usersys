package com.springboot.activiti.api;

import com.common.Assist;
import com.common.ResultUtil;
import com.common.vo.Result;
import com.springboot.activiti.commom.ProcessUtil;
import com.springboot.activiti.domain.LeaveInfo;
import com.springboot.activiti.domain.vo.LeaveInfoForm;
import com.springboot.activiti.domain.vo.TaskOverVo;
import com.springboot.activiti.service.LeaveInfoService;
import com.springboot.activiti.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Act")
@Api(tags = "流程申请", value = "流程接口")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    LeaveInfoService leaveInfoService;
    @Autowired
    ProcessUtil processUtil;

    @ApiOperation(value = "第一步 点击保存按钮,新增一个请假单(created by chenshangxian)")
    @PostMapping("/addLeaveInfo")
    //新增一个请假单
    //这里请假单从简
    public Result addLeaveInfo(@Param(value = "请假事由") @RequestBody LeaveInfoForm msg) {
        int i = schoolService.addLeaveInfo(msg);
        if (i > 0) {
            return ResultUtil.success("新增成功");
        } else {
            return ResultUtil.error("新增失败");
        }
    }

    /**
     * @Param:描述:业务阶段需要再传一个参数(流程图的id),这里的流程图id暂时写死
     * @return：返回结果描述:
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-4-27 11:12
     */
    @ApiOperation(value = "第二步 点击启动按钮,使请假单开始生效(created by chenshangxian)")
    @GetMapping("/goByLeaveId")
    public Result goByLeaveId(@Param(value = "请假单外键") @RequestParam String leaveFkCode) {
        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("FK_CODE", leaveFkCode));
        LeaveInfo info = new LeaveInfo();
        info.setStatus("(NULL)");
        //这是草稿状态
        int i = leaveInfoService.updateNonEmptyLeaveInfo(info, assist);

        //调用activiti工具类,启动流程(这是提交操作,直接是审核中状态)
        processUtil.startProcess(String.valueOf(leaveFkCode));
        if (i > 0) {
            return ResultUtil.success("启动成功");
        } else {
            return ResultUtil.error("启动失败");
        }
    }

    @ApiOperation(value = "第三步 通过用户外键查询相关的待办事项(created by chenshangxian)")
    @GetMapping("/queryByUserId")
    //查询代办
    public Result queryByUserId(@RequestParam String userFkCode) {
        List<LeaveInfo> leaveInfos = schoolService.queryByUserId(userFkCode);
        return ResultUtil.success(leaveInfos);
    }

    @ApiOperation(value = "第四步 完成待办任务(created by chenshangxian)")
    @PostMapping("/completeTaskByUser")
    //完成任务
    public Result completeTaskByUser(@RequestBody TaskOverVo taskOverVo) {
        //使流程节点往前走一步
        schoolService.completeTaskByUser(taskOverVo);
        return ResultUtil.success("执行成功");
    }


    @ApiOperation(value = "根据用户外键,查询自己名下的请假单(created by chenshangxian)")
    @PostMapping("/SelectAllLeave")
    //完成任务
    public Result selectAllLeave(@RequestBody TaskOverVo taskOverVo) {

        schoolService.completeTaskByUser(taskOverVo);
        return ResultUtil.success("执行成功");
    }

}
