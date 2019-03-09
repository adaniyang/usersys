package com.springboot.usersys.pojo;

import java.util.Date;

//@ApiModel(description = "用户实体user")
public class User {
    private Long id;
    private String userAccount;
    private String pwd;
    private Integer delStatus;
    private Date createTime;
    private Date updateTime;

//    @ApiModelProperty(value = "Id值",dataType = "Long",required = true)


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //    @ApiModelProperty(value = "用户名",dataType = "String",required = true)
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

//    @ApiModelProperty(value = "密码",dataType = "String",required = true)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

//    @ApiModelProperty(value = "删除状态 0:已删除 1:未删除",dataType = "Integer",required = true)
    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
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
}
