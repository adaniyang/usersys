package com.springboot.leaveProcess.processApproval.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 11:16
 * @Modify by:
 */
@ApiModel
public class LeaveVo {
    @ApiModelProperty(value = "请假单外键", dataType = "String")
    private String fkCode;//请假单外键
    @ApiModelProperty(value = "请假人外键", dataType = "String")
    private String userFkCode;//请假人外键
    @ApiModelProperty(value = "请假人名字", dataType = "String")
    private String userName;//请假人名字
    @ApiModelProperty(value = "请假类型(1事假,2病假.)", dataType = "Integer")
    private Integer leaveType;//请假类型(1事假,2病假.)
    @ApiModelProperty(value = "请假内容", dataType = "String")
    private String leaveMsg;//请假内容
    @ApiModelProperty(value = "请假开始时间", dataType = "String")
    private String leaveStartTime;//请假开始时间
    @ApiModelProperty(value = "请假结束时间", dataType = "String")
    private String leaveEndTime;//请假结束时间
    @ApiModelProperty(value = "状态 0:草稿 1:已生效", dataType = "Integer")
    private Integer status;//状态 0:草稿 1:已生效
    @ApiModelProperty(value = "创建时间", dataType = "String")
    private String createTime;
    @ApiModelProperty(value = "修改时间", dataType = "String")
    private String updateTime;
    @ApiModelProperty(value = "启动状态 0.没有启动过 1.已启动", dataType = "Integer")
    private Integer startStatus;//启动状态 0.没有启动过 1.已启动
    @ApiModelProperty(value = "流程id", dataType = "String")
    private String processId;//流程id

    public String getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(String userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveMsg() {
        return leaveMsg;
    }

    public void setLeaveMsg(String leaveMsg) {
        this.leaveMsg = leaveMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFkCode() {
        return fkCode;
    }

    public void setFkCode(String fkCode) {
        this.fkCode = fkCode;
    }

    public String getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(String leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public String getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(String leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
