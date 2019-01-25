package com.springboot.leaveProcess.processApproval.pojo.domain;

import java.util.Date;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/25 11:57
 * @Modify by:
 */
public class ProcessApprovalUserDomain {
    private Long id;
    private Long fkCode;//外键
    private Long userFkCode;//人员外键
    private Integer deleteStatus;//删除状态 0:已删除 1:未删除
    private Date createTime;
    private Date updateTime;
    private Integer level;//审核人节点(第一节点审核人存1,第二节点存2)
    private String processType;//审核人属于那种流程图类别(请假单存QJ)

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

    public Long getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(Long userFkCode) {
        this.userFkCode = userFkCode;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }
}
