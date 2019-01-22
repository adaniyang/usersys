package com.springboot.activiti.domain;
public class LeaveInfo {
    private Long id;//主键
    private String status;//请假流程
    private String leaveName;//请假人名字
    private Integer leaveType;//请假单类型
    private Integer delStatus;//删除状态
    private String leaveMsg;//请假内容
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//修改时间
    private Long leaveUserFkCode;//请假单用户id
    private Long fkCode;//外键
    private Long processId;//业务单据id(用于走流程)
    public LeaveInfo() {
        super();
    }
    public LeaveInfo(Long id,String status,String leaveName,Integer leaveType,Integer delStatus,String leaveMsg,java.util.Date createTime,java.util.Date updateTime,Long leaveUserFkCode,Long fkCode,Long processId) {
        super();
        this.id = id;
        this.status = status;
        this.leaveName = leaveName;
        this.leaveType = leaveType;
        this.delStatus = delStatus;
        this.leaveMsg = leaveMsg;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.leaveUserFkCode = leaveUserFkCode;
        this.fkCode = fkCode;
        this.processId = processId;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeaveName() {
        return this.leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public Integer getLeaveType() {
        return this.leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getLeaveMsg() {
        return this.leaveMsg;
    }

    public void setLeaveMsg(String leaveMsg) {
        this.leaveMsg = leaveMsg;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLeaveUserFkCode() {
        return this.leaveUserFkCode;
    }

    public void setLeaveUserFkCode(Long leaveUserFkCode) {
        this.leaveUserFkCode = leaveUserFkCode;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public Long getProcessId() {
        return this.processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

}
