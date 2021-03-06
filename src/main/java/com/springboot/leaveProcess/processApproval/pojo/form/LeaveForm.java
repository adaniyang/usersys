package com.springboot.leaveProcess.processApproval.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 11:16
 * @Modify by:
 */
@ApiModel
public class LeaveForm {
    @ApiModelProperty(value = "请假人外键", dataType = "String", required = true)
    private String userFkCode;//请假人外键
    @ApiModelProperty(value = "请假人名字", dataType = "String", required = true)
    private String userName;//请假人名字
    @ApiModelProperty(value = "请假类型(1事假,2病假.)", dataType = "Integer", required = true)
    private Integer leaveType;//请假类型(1事假,2病假.)
    @ApiModelProperty(value = "请假内容", dataType = "String", required = true)
    private String leaveMsg;//请假内容
    @ApiModelProperty(value = "请假开始时间", dataType = "String", required = true)
    private String leaveStartTime;//请假开始时间
    @ApiModelProperty(value = "请假结束时间", dataType = "String", required = true)
    private String leaveEndTime;//请假结束时间
    @ApiModelProperty(value = "状态 0:草稿 1:已生效", dataType = "Integer", required = true)
    private Integer status;//状态 0:草稿 1:已生效

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
