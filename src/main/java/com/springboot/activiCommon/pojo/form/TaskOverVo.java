package com.springboot.activiCommon.pojo.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TaskOverVo {
    @ApiModelProperty(value = "业务单据外键(就是taskId)", dataType = "String", required = true)
    private String taskFkCode;
    @ApiModelProperty(value = "审批人外键", dataType = "String", required = true)
    private String userFkCode;
    @ApiModelProperty(value = "是否通过,通过传pass,不通过传reject", dataType = "String", required = true)
    private String aduit;
    @ApiModelProperty(value = "请假天数(用于分支流程,无分支的无该字段)", dataType = "String", required = true)
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTaskFkCode() {
        return taskFkCode;
    }

    public void setTaskFkCode(String taskFkCode) {
        this.taskFkCode = taskFkCode;
    }

    public String getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(String userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getAduit() {
        return aduit;
    }

    public void setAduit(String aduit) {
        this.aduit = aduit;
    }
}
