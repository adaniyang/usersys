package com.springboot.leaveProcess.processApproval.pojo.domain;

import java.util.Date;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/23 11:16
 * @Modify by:
 */
public class LeaveDomain {
    private Long id;
    private Long fkCode;//请假单外键
    private Long userFkCode;//请假人外键
    private String userName;//请假人名字
    private Integer leaveType;//请假类型 1事假 2病假
    private String leaveMsg;//请假内容
    private Date leaveStartTime;//请假开始时间
    private Date leaveEndTime;//请假结束时间
    private Integer status;//状态 0:草稿 1:已生效
    private Integer deleteStatus;//删除状态 0:已删除 1:未删除
    private Date createTime;
    private Date updateTime;
    private Integer startStatus;//启动状态 0.没有启动过 1.已启动
    private Long processId;//流程id

    public Integer getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Integer startStatus) {
        this.startStatus = startStatus;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkCode() {
        return fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public void setUserFkCode(Long userFkCode) {
        this.userFkCode = userFkCode;
    }

    public Long getUserFkCode() {
        return userFkCode;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public Date getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}
