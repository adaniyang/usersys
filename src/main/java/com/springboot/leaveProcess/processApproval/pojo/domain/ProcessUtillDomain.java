package com.springboot.leaveProcess.processApproval.pojo.domain;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/1/25 10:57
 * @Modify by:
 */
public class ProcessUtillDomain {
    private Long id;
    private Long fkCode;
    private String type;//类型，是什么类型的流程

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
